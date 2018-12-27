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
    private a erj;
    private b erk;
    private boolean mHasMore = true;
    private boolean erl = false;
    private b.a erm = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<h> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.erj.getListView().completePullRefreshPostDelayed(SystemScreenshotManager.DELAY_TIME);
            GodSquareActivity.this.erj.hideLoadingView();
            if (v.I(list)) {
                GodSquareActivity.this.erj.aKt();
                if (v.I(GodSquareActivity.this.erk.dHr)) {
                    GodSquareActivity.this.erj.nW(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.ll()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.erj.aba();
            if (z) {
                GodSquareActivity.this.erk.dHr = list;
                GodSquareActivity.this.erj.ch(GodSquareActivity.this.erk.dHr);
            } else {
                GodSquareActivity.this.erk.dHr.addAll(list);
                GodSquareActivity.this.erj.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.erj.aKs();
            } else {
                GodSquareActivity.this.erj.aKu();
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
                    if (GodSquareActivity.this.erk.ch(com.baidu.adp.lib.g.b.d(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.erl = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a dcc = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void bF(boolean z) {
            if (z) {
                if (v.I(GodSquareActivity.this.erk.dHr)) {
                    GodSquareActivity.this.aKr();
                } else {
                    GodSquareActivity.this.erj.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.erj = new a(this);
        this.erj.g(this.dcc);
        this.erk = new b(this.erm, this);
        registerListener(this.mAttentionListener);
        aKr();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.erj.notifyDataSetChanged();
        if (this.erl) {
            this.erj.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aKr() {
        this.erj.showLoadingView();
        this.erk.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.kK()) {
            aKr();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.erj.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.j.b
    public void bH(boolean z) {
        this.erl = false;
        this.erk.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.erk.aad();
            this.erj.aKs();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
