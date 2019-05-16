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
    private a fUZ;
    private b fVa;
    private boolean mHasMore = true;
    private boolean fVb = false;
    private b.a fVc = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<m> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.fUZ.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.fUZ.hideLoadingView();
            if (v.aa(list)) {
                GodSquareActivity.this.fUZ.bsn();
                if (v.aa(GodSquareActivity.this.fVa.fll)) {
                    GodSquareActivity.this.fUZ.wk(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.ki()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.fUZ.aHH();
            if (z) {
                GodSquareActivity.this.fVa.fll = list;
                GodSquareActivity.this.fUZ.cx(GodSquareActivity.this.fVa.fll);
            } else {
                GodSquareActivity.this.fVa.fll.addAll(list);
                GodSquareActivity.this.fUZ.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.fUZ.bsm();
            } else {
                GodSquareActivity.this.fUZ.bso();
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
                    if (GodSquareActivity.this.fVa.dh(com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.fVb = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a eCk = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void el(boolean z) {
            if (z) {
                if (v.aa(GodSquareActivity.this.fVa.fll)) {
                    GodSquareActivity.this.bsl();
                } else {
                    GodSquareActivity.this.fUZ.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fUZ = new a(this);
        this.fUZ.g(this.eCk);
        this.fVa = new b(this.fVc, this);
        registerListener(this.mAttentionListener);
        bsl();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fUZ.notifyDataSetChanged();
        if (this.fVb) {
            this.fUZ.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsl() {
        this.fUZ.showLoadingView();
        this.fVa.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.jG()) {
            bsl();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fUZ.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void en(boolean z) {
        this.fVb = false;
        this.fVa.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.fVa.aHq();
            this.fUZ.bsm();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
