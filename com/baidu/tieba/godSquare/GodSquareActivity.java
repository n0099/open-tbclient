package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes6.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, h.c {
    private a fVa;
    private b fVb;
    private boolean mHasMore = true;
    private boolean fVc = false;
    private b.a fVd = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<m> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.fVa.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.fVa.hideLoadingView();
            if (v.aa(list)) {
                GodSquareActivity.this.fVa.bsq();
                if (v.aa(GodSquareActivity.this.fVb.flm)) {
                    GodSquareActivity.this.fVa.wk(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.ki()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.fVa.aHK();
            if (z) {
                GodSquareActivity.this.fVb.flm = list;
                GodSquareActivity.this.fVa.cx(GodSquareActivity.this.fVb.flm);
            } else {
                GodSquareActivity.this.fVb.flm.addAll(list);
                GodSquareActivity.this.fVa.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.fVa.bsp();
            } else {
                GodSquareActivity.this.fVa.bsr();
            }
        }
    };
    private CustomMessageListener mAttentionListener = new CustomMessageListener(2001115) { // from class: com.baidu.tieba.godSquare.GodSquareActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (GodSquareActivity.this.fVb.dh(com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.fVc = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a eCl = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (z) {
                if (v.aa(GodSquareActivity.this.fVb.flm)) {
                    GodSquareActivity.this.bso();
                } else {
                    GodSquareActivity.this.fVa.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fVa = new a(this);
        this.fVa.g(this.eCl);
        this.fVb = new b(this.fVd, this);
        registerListener(this.mAttentionListener);
        bso();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fVa.notifyDataSetChanged();
        if (this.fVc) {
            this.fVa.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bso() {
        this.fVa.showLoadingView();
        this.fVb.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jG()) {
            bso();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fVa.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        this.fVc = false;
        this.fVb.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.fVb.aHt();
            this.fVa.bsp();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
