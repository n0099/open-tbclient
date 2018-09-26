package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes3.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, j.b {
    private a dYl;
    private b dYm;
    private boolean mHasMore = true;
    private boolean dYn = false;
    private b.a dYo = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<h> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.dYl.getListView().completePullRefreshPostDelayed(2000L);
            GodSquareActivity.this.dYl.hideLoadingView();
            if (v.z(list)) {
                GodSquareActivity.this.dYl.aEX();
                if (v.z(GodSquareActivity.this.dYm.doK)) {
                    GodSquareActivity.this.dYl.mR(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.lb()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.dYl.Wa();
            if (z) {
                GodSquareActivity.this.dYm.doK = list;
                GodSquareActivity.this.dYl.bO(GodSquareActivity.this.dYm.doK);
            } else {
                GodSquareActivity.this.dYm.doK.addAll(list);
                GodSquareActivity.this.dYl.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.dYl.aEW();
            } else {
                GodSquareActivity.this.dYl.aEY();
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
                    if (GodSquareActivity.this.dYm.bT(com.baidu.adp.lib.g.b.d(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.dYn = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a cJe = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bd(boolean z) {
            if (z) {
                if (v.z(GodSquareActivity.this.dYm.doK)) {
                    GodSquareActivity.this.aEV();
                } else {
                    GodSquareActivity.this.dYl.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dYl = new a(this);
        this.dYl.g(this.cJe);
        this.dYm = new b(this.dYo, this);
        registerListener(this.mAttentionListener);
        aEV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dYl.notifyDataSetChanged();
        if (this.dYn) {
            this.dYl.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aEV() {
        this.dYl.showLoadingView();
        this.dYm.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.ky()) {
            aEV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dYl.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bf(boolean z) {
        this.dYn = false;
        this.dYm.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.dYm.Vd();
            this.dYl.aEW();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
