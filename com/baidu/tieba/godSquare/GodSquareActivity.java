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
/* loaded from: classes11.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, g.c {
    private a gUZ;
    private b gVa;
    private boolean mHasMore = true;
    private boolean gVb = false;
    private b.a gVc = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<m> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.gUZ.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.gUZ.hideLoadingView();
            if (v.isEmpty(list)) {
                GodSquareActivity.this.gUZ.bMC();
                if (v.isEmpty(GodSquareActivity.this.gVa.gkP)) {
                    GodSquareActivity.this.gUZ.AZ(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.isNetOk()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.gUZ.bcy();
            if (z) {
                GodSquareActivity.this.gVa.gkP = list;
                GodSquareActivity.this.gUZ.cz(GodSquareActivity.this.gVa.gkP);
            } else {
                GodSquareActivity.this.gVa.gkP.addAll(list);
                GodSquareActivity.this.gUZ.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.gUZ.bMB();
            } else {
                GodSquareActivity.this.gUZ.bMD();
            }
        }
    };
    private CustomMessageListener dag = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.godSquare.GodSquareActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (GodSquareActivity.this.gVa.dB(com.baidu.adp.lib.f.b.toLong(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.gVb = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a fYY = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                if (v.isEmpty(GodSquareActivity.this.gVa.gkP)) {
                    GodSquareActivity.this.bMA();
                } else {
                    GodSquareActivity.this.gUZ.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUZ = new a(this);
        this.gUZ.f(this.fYY);
        this.gVa = new b(this.gVc, this);
        registerListener(this.dag);
        bMA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gUZ.notifyDataSetChanged();
        if (this.gVb) {
            this.gUZ.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMA() {
        this.gUZ.showLoadingView();
        this.gVa.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            bMA();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gUZ.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        this.gVb = false;
        this.gVa.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.gVa.bcg();
            this.gUZ.bMB();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.GOD_SQUARE;
    }
}
