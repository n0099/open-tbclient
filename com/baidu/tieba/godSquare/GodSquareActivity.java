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
    private a fEo;
    private b fEp;
    private boolean mHasMore = true;
    private boolean fEq = false;
    private b.a fEr = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<m> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.fEo.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.fEo.hideLoadingView();
            if (v.T(list)) {
                GodSquareActivity.this.fEo.bkY();
                if (v.T(GodSquareActivity.this.fEp.eVo)) {
                    GodSquareActivity.this.fEo.uR(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.lo()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.fEo.aBt();
            if (z) {
                GodSquareActivity.this.fEp.eVo = list;
                GodSquareActivity.this.fEo.cs(GodSquareActivity.this.fEp.eVo);
            } else {
                GodSquareActivity.this.fEp.eVo.addAll(list);
                GodSquareActivity.this.fEo.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.fEo.bkX();
            } else {
                GodSquareActivity.this.fEo.bkZ();
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
                    if (GodSquareActivity.this.fEp.cK(com.baidu.adp.lib.g.b.d(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.fEq = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a emM = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void dP(boolean z) {
            if (z) {
                if (v.T(GodSquareActivity.this.fEp.eVo)) {
                    GodSquareActivity.this.bkW();
                } else {
                    GodSquareActivity.this.fEo.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fEo = new a(this);
        this.fEo.g(this.emM);
        this.fEp = new b(this.fEr, this);
        registerListener(this.mAttentionListener);
        bkW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.fEo.notifyDataSetChanged();
        if (this.fEq) {
            this.fEo.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bkW() {
        this.fEo.showLoadingView();
        this.fEp.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.kM()) {
            bkW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.fEo.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void dR(boolean z) {
        this.fEq = false;
        this.fEp.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.fEp.aBc();
            this.fEo.bkX();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
