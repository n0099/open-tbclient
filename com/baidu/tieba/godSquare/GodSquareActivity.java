package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.searchbox.ng.ai.apps.screenshot.SystemScreenshotManager;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.j;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes3.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, j.b {
    private a eot;
    private b eou;
    private boolean mHasMore = true;
    private boolean eov = false;
    private b.a eow = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<h> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.eot.getListView().completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            GodSquareActivity.this.eot.hideLoadingView();
            if (v.I(list)) {
                GodSquareActivity.this.eot.aJE();
                if (v.I(GodSquareActivity.this.eou.dED)) {
                    GodSquareActivity.this.eot.nT(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.ll()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.eot.aaY();
            if (z) {
                GodSquareActivity.this.eou.dED = list;
                GodSquareActivity.this.eot.cg(GodSquareActivity.this.eou.dED);
            } else {
                GodSquareActivity.this.eou.dED.addAll(list);
                GodSquareActivity.this.eot.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.eot.aJD();
            } else {
                GodSquareActivity.this.eot.aJF();
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
                    if (GodSquareActivity.this.eou.cc(com.baidu.adp.lib.g.b.d(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.eov = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a cZk = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                if (v.I(GodSquareActivity.this.eou.dED)) {
                    GodSquareActivity.this.aJC();
                } else {
                    GodSquareActivity.this.eot.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eot = new a(this);
        this.eot.g(this.cZk);
        this.eou = new b(this.eow, this);
        registerListener(this.mAttentionListener);
        aJC();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.eot.notifyDataSetChanged();
        if (this.eov) {
            this.eot.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJC() {
        this.eot.showLoadingView();
        this.eou.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kK()) {
            aJC();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.eot.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
        this.eov = false;
        this.eou.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.eou.aab();
            this.eot.aJD();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
