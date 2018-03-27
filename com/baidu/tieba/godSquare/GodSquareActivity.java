package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes3.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, j.b {
    private a eea;
    private b eeb;
    private boolean mHasMore = true;
    private boolean eec = false;
    private b.a eed = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<i> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.eea.getListView().completePullRefreshPostDelayed(2000L);
            GodSquareActivity.this.eea.VV();
            if (v.E(list)) {
                GodSquareActivity.this.eea.aBL();
                if (v.E(GodSquareActivity.this.eeb.dBk)) {
                    GodSquareActivity.this.eea.lB(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.pa()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.eea.XN();
            if (z) {
                GodSquareActivity.this.eeb.dBk = list;
                GodSquareActivity.this.eea.bI(GodSquareActivity.this.eeb.dBk);
            } else {
                GodSquareActivity.this.eeb.dBk.addAll(list);
                GodSquareActivity.this.eea.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.eea.aBK();
            } else {
                GodSquareActivity.this.eea.aBM();
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
                    if (GodSquareActivity.this.eeb.bK(com.baidu.adp.lib.g.b.c(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.eec = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a dbo = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bu(boolean z) {
            if (z) {
                if (v.E(GodSquareActivity.this.eeb.dBk)) {
                    GodSquareActivity.this.aBJ();
                } else {
                    GodSquareActivity.this.eea.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eea = new a(this);
        this.eea.g(this.dbo);
        this.eeb = new b(this.eed, this);
        registerListener(this.mAttentionListener);
        aBJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eea.notifyDataSetChanged();
        if (this.eec) {
            this.eea.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBJ() {
        this.eea.VU();
        this.eeb.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.ox()) {
            aBJ();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eea.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bw(boolean z) {
        this.eec = false;
        this.eeb.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.eeb.WO();
            this.eea.aBK();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
