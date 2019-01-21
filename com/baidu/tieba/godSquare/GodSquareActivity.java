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
    private a erR;
    private b erS;
    private boolean mHasMore = true;
    private boolean erT = false;
    private b.a erU = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<h> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.erR.getListView().completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            GodSquareActivity.this.erR.hideLoadingView();
            if (v.I(list)) {
                GodSquareActivity.this.erR.aKR();
                if (v.I(GodSquareActivity.this.erS.dIb)) {
                    GodSquareActivity.this.erR.oo(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.ll()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.erR.abx();
            if (z) {
                GodSquareActivity.this.erS.dIb = list;
                GodSquareActivity.this.erR.ci(GodSquareActivity.this.erS.dIb);
            } else {
                GodSquareActivity.this.erS.dIb.addAll(list);
                GodSquareActivity.this.erR.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.erR.aKQ();
            } else {
                GodSquareActivity.this.erR.aKS();
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
                    if (GodSquareActivity.this.erS.ch(com.baidu.adp.lib.g.b.d(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.erT = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a dcQ = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            if (z) {
                if (v.I(GodSquareActivity.this.erS.dIb)) {
                    GodSquareActivity.this.aKP();
                } else {
                    GodSquareActivity.this.erR.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.erR = new a(this);
        this.erR.g(this.dcQ);
        this.erS = new b(this.erU, this);
        registerListener(this.mAttentionListener);
        aKP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.erR.notifyDataSetChanged();
        if (this.erT) {
            this.erR.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKP() {
        this.erR.showLoadingView();
        this.erS.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kK()) {
            aKP();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.erR.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bI(boolean z) {
        this.erT = false;
        this.erS.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.erS.aaA();
            this.erR.aKQ();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
