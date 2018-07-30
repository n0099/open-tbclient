package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes3.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, g.b {
    private a dQY;
    private b dQZ;
    private boolean mHasMore = true;
    private boolean dRa = false;
    private b.a dRb = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<h> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.dQY.getListView().completePullRefreshPostDelayed(2000L);
            GodSquareActivity.this.dQY.hideLoadingView();
            if (w.z(list)) {
                GodSquareActivity.this.dQY.aCN();
                if (w.z(GodSquareActivity.this.dQZ.diT)) {
                    GodSquareActivity.this.dQY.mn(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.jV()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.dQY.Uk();
            if (z) {
                GodSquareActivity.this.dQZ.diT = list;
                GodSquareActivity.this.dQY.bN(GodSquareActivity.this.dQZ.diT);
            } else {
                GodSquareActivity.this.dQZ.diT.addAll(list);
                GodSquareActivity.this.dQY.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.dQY.aCM();
            } else {
                GodSquareActivity.this.dQY.aCO();
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
                    if (GodSquareActivity.this.dQZ.bP(com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.dRa = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a cDq = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void aQ(boolean z) {
            if (z) {
                if (w.z(GodSquareActivity.this.dQZ.diT)) {
                    GodSquareActivity.this.aCL();
                } else {
                    GodSquareActivity.this.dQY.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dQY = new a(this);
        this.dQY.g(this.cDq);
        this.dQZ = new b(this.dRb, this);
        registerListener(this.mAttentionListener);
        aCL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.dQY.notifyDataSetChanged();
        if (this.dRa) {
            this.dQY.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aCL() {
        this.dQY.showLoadingView();
        this.dQZ.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.js()) {
            aCL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.dQY.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.b
    public void aS(boolean z) {
        this.dRa = false;
        this.dQZ.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.dQZ.Tn();
            this.dQY.aCM();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
