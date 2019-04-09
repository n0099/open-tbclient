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
    private a fEc;
    private b fEd;
    private boolean mHasMore = true;
    private boolean fEe = false;
    private b.a fEf = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<m> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.fEc.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.fEc.hideLoadingView();
            if (v.T(list)) {
                GodSquareActivity.this.fEc.bkV();
                if (v.T(GodSquareActivity.this.fEd.eVb)) {
                    GodSquareActivity.this.fEc.uQ(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.lo()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.fEc.aBq();
            if (z) {
                GodSquareActivity.this.fEd.eVb = list;
                GodSquareActivity.this.fEc.cp(GodSquareActivity.this.fEd.eVb);
            } else {
                GodSquareActivity.this.fEd.eVb.addAll(list);
                GodSquareActivity.this.fEc.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.fEc.bkU();
            } else {
                GodSquareActivity.this.fEc.bkW();
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
                    if (GodSquareActivity.this.fEd.cK(com.baidu.adp.lib.g.b.d(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.fEe = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a emz = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                if (v.T(GodSquareActivity.this.fEd.eVb)) {
                    GodSquareActivity.this.bkT();
                } else {
                    GodSquareActivity.this.fEc.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fEc = new a(this);
        this.fEc.g(this.emz);
        this.fEd = new b(this.fEf, this);
        registerListener(this.mAttentionListener);
        bkT();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fEc.notifyDataSetChanged();
        if (this.fEe) {
            this.fEc.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkT() {
        this.fEc.showLoadingView();
        this.fEd.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kM()) {
            bkT();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fEc.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        this.fEe = false;
        this.fEd.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.fEd.aAZ();
            this.fEc.bkU();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
