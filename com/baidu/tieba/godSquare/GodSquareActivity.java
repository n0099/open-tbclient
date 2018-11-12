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
    private b ehA;
    private a ehz;
    private boolean mHasMore = true;
    private boolean ehB = false;
    private b.a ehC = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<h> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.ehz.getListView().completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            GodSquareActivity.this.ehz.hideLoadingView();
            if (v.I(list)) {
                GodSquareActivity.this.ehz.aHN();
                if (v.I(GodSquareActivity.this.ehA.dye)) {
                    GodSquareActivity.this.ehz.nu(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.lm()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.ehz.ZS();
            if (z) {
                GodSquareActivity.this.ehA.dye = list;
                GodSquareActivity.this.ehz.cc(GodSquareActivity.this.ehA.dye);
            } else {
                GodSquareActivity.this.ehA.dye.addAll(list);
                GodSquareActivity.this.ehz.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.ehz.aHM();
            } else {
                GodSquareActivity.this.ehz.aHO();
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
                    if (GodSquareActivity.this.ehA.bV(com.baidu.adp.lib.g.b.d(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.ehB = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a cSD = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bE(boolean z) {
            if (z) {
                if (v.I(GodSquareActivity.this.ehA.dye)) {
                    GodSquareActivity.this.aHL();
                } else {
                    GodSquareActivity.this.ehz.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ehz = new a(this);
        this.ehz.g(this.cSD);
        this.ehA = new b(this.ehC, this);
        registerListener(this.mAttentionListener);
        aHL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.ehz.notifyDataSetChanged();
        if (this.ehB) {
            this.ehz.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aHL() {
        this.ehz.showLoadingView();
        this.ehA.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kK()) {
            aHL();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.ehz.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bG(boolean z) {
        this.ehB = false;
        this.ehA.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.ehA.YV();
            this.ehz.aHM();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
