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
    private a fVc;
    private b fVd;
    private boolean mHasMore = true;
    private boolean fVe = false;
    private b.a fVf = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<m> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.fVc.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.fVc.hideLoadingView();
            if (v.aa(list)) {
                GodSquareActivity.this.fVc.bss();
                if (v.aa(GodSquareActivity.this.fVd.flm)) {
                    GodSquareActivity.this.fVc.wj(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.ki()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.fVc.aHK();
            if (z) {
                GodSquareActivity.this.fVd.flm = list;
                GodSquareActivity.this.fVc.cx(GodSquareActivity.this.fVd.flm);
            } else {
                GodSquareActivity.this.fVd.flm.addAll(list);
                GodSquareActivity.this.fVc.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.fVc.bsr();
            } else {
                GodSquareActivity.this.fVc.bst();
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
                    if (GodSquareActivity.this.fVd.dh(com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.fVe = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a eCl = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (z) {
                if (v.aa(GodSquareActivity.this.fVd.flm)) {
                    GodSquareActivity.this.bsq();
                } else {
                    GodSquareActivity.this.fVc.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fVc = new a(this);
        this.fVc.g(this.eCl);
        this.fVd = new b(this.fVf, this);
        registerListener(this.mAttentionListener);
        bsq();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fVc.notifyDataSetChanged();
        if (this.fVe) {
            this.fVc.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsq() {
        this.fVc.showLoadingView();
        this.fVd.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jG()) {
            bsq();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fVc.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        this.fVe = false;
        this.fVd.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.fVd.aHt();
            this.fVc.bsr();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
