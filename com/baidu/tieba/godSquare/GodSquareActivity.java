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
    private a egf;
    private b egg;
    private boolean mHasMore = true;
    private boolean egh = false;
    private b.a egi = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<h> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.egf.getListView().completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            GodSquareActivity.this.egf.hideLoadingView();
            if (v.J(list)) {
                GodSquareActivity.this.egf.aIp();
                if (v.J(GodSquareActivity.this.egg.dwM)) {
                    GodSquareActivity.this.egf.nt(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.lo()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.egf.ZI();
            if (z) {
                GodSquareActivity.this.egg.dwM = list;
                GodSquareActivity.this.egf.ce(GodSquareActivity.this.egg.dwM);
            } else {
                GodSquareActivity.this.egg.dwM.addAll(list);
                GodSquareActivity.this.egf.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.egf.aIo();
            } else {
                GodSquareActivity.this.egf.aIq();
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
                    if (GodSquareActivity.this.egg.ca(com.baidu.adp.lib.g.b.d(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.egh = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a cRx = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bn(boolean z) {
            if (z) {
                if (v.J(GodSquareActivity.this.egg.dwM)) {
                    GodSquareActivity.this.aIn();
                } else {
                    GodSquareActivity.this.egf.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.egf = new a(this);
        this.egf.g(this.cRx);
        this.egg = new b(this.egi, this);
        registerListener(this.mAttentionListener);
        aIn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.egf.notifyDataSetChanged();
        if (this.egh) {
            this.egf.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aIn() {
        this.egf.showLoadingView();
        this.egg.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kM()) {
            aIn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.egf.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bp(boolean z) {
        this.egh = false;
        this.egg.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.egg.YL();
            this.egf.aIo();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
