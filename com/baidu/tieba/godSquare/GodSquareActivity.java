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
    private a erQ;
    private b erR;
    private boolean mHasMore = true;
    private boolean erS = false;
    private b.a erT = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<h> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.erQ.getListView().completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            GodSquareActivity.this.erQ.hideLoadingView();
            if (v.I(list)) {
                GodSquareActivity.this.erQ.aKR();
                if (v.I(GodSquareActivity.this.erR.dIa)) {
                    GodSquareActivity.this.erQ.oo(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.ll()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.erQ.abx();
            if (z) {
                GodSquareActivity.this.erR.dIa = list;
                GodSquareActivity.this.erQ.ci(GodSquareActivity.this.erR.dIa);
            } else {
                GodSquareActivity.this.erR.dIa.addAll(list);
                GodSquareActivity.this.erQ.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.erQ.aKQ();
            } else {
                GodSquareActivity.this.erQ.aKS();
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
                    if (GodSquareActivity.this.erR.ch(com.baidu.adp.lib.g.b.d(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.erS = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a dcP = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bG(boolean z) {
            if (z) {
                if (v.I(GodSquareActivity.this.erR.dIa)) {
                    GodSquareActivity.this.aKP();
                } else {
                    GodSquareActivity.this.erQ.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.erQ = new a(this);
        this.erQ.g(this.dcP);
        this.erR = new b(this.erT, this);
        registerListener(this.mAttentionListener);
        aKP();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.erQ.notifyDataSetChanged();
        if (this.erS) {
            this.erQ.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKP() {
        this.erQ.showLoadingView();
        this.erR.update();
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
        this.erQ.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bI(boolean z) {
        this.erS = false;
        this.erR.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.erR.aaA();
            this.erQ.aKQ();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
