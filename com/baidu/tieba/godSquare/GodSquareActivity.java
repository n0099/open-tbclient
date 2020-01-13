package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.g;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes9.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, g.c {
    private a gSL;
    private b gSM;
    private boolean mHasMore = true;
    private boolean gSN = false;
    private b.a gSO = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<m> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.gSL.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.gSL.hideLoadingView();
            if (v.isEmpty(list)) {
                GodSquareActivity.this.gSL.bKX();
                if (v.isEmpty(GodSquareActivity.this.gSM.giz)) {
                    GodSquareActivity.this.gSL.AI(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.isNetOk()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.gSL.baf();
            if (z) {
                GodSquareActivity.this.gSM.giz = list;
                GodSquareActivity.this.gSL.cD(GodSquareActivity.this.gSM.giz);
            } else {
                GodSquareActivity.this.gSM.giz.addAll(list);
                GodSquareActivity.this.gSL.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.gSL.bKW();
            } else {
                GodSquareActivity.this.gSL.bKY();
            }
        }
    };
    private CustomMessageListener cWc = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.godSquare.GodSquareActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (GodSquareActivity.this.gSM.dB(com.baidu.adp.lib.f.b.toLong(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.gSN = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a fWI = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                if (v.isEmpty(GodSquareActivity.this.gSM.giz)) {
                    GodSquareActivity.this.bKV();
                } else {
                    GodSquareActivity.this.gSL.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gSL = new a(this);
        this.gSL.f(this.fWI);
        this.gSM = new b(this.gSO, this);
        registerListener(this.cWc);
        bKV();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gSL.notifyDataSetChanged();
        if (this.gSN) {
            this.gSL.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKV() {
        this.gSL.showLoadingView();
        this.gSM.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            bKV();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gSL.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        this.gSN = false;
        this.gSM.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.gSM.aZN();
            this.gSL.bKW();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.GOD_SQUARE;
    }
}
