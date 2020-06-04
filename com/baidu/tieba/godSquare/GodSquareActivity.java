package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes11.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, f.c {
    private a hVC;
    private b hVD;
    private boolean mHasMore = true;
    private boolean hVE = false;
    private b.a hVF = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<o> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.hVC.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.hVC.hideLoadingView();
            if (v.isEmpty(list)) {
                GodSquareActivity.this.hVC.cdW();
                if (v.isEmpty(GodSquareActivity.this.hVD.hjG)) {
                    GodSquareActivity.this.hVC.Ex(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.isNetOk()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.hVC.bqQ();
            if (z) {
                GodSquareActivity.this.hVD.hjG = list;
                GodSquareActivity.this.hVC.cI(GodSquareActivity.this.hVD.hjG);
            } else {
                GodSquareActivity.this.hVD.hjG.addAll(list);
                GodSquareActivity.this.hVC.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.hVC.cdV();
            } else {
                GodSquareActivity.this.hVC.cdX();
            }
        }
    };
    private CustomMessageListener dNP = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.godSquare.GodSquareActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (GodSquareActivity.this.hVD.el(com.baidu.adp.lib.f.b.toLong(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.hVE = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a faB = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                if (v.isEmpty(GodSquareActivity.this.hVD.hjG)) {
                    GodSquareActivity.this.cdU();
                } else {
                    GodSquareActivity.this.hVC.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hVC = new a(this);
        this.hVC.f(this.faB);
        this.hVD = new b(this.hVF, this);
        registerListener(this.dNP);
        cdU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.hVC.notifyDataSetChanged();
        if (this.hVE) {
            this.hVC.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdU() {
        this.hVC.showLoadingView();
        this.hVD.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            cdU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.hVC.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.hVE = false;
        this.hVD.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.hVD.bqx();
            this.hVC.cdV();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.GOD_SQUARE;
    }
}
