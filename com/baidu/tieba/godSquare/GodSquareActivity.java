package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes8.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, f.c {
    private a jXD;
    private b jXE;
    private boolean mHasMore = true;
    private boolean jXF = false;
    private b.a jXG = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<n> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.jXD.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.jXD.hideLoadingView();
            if (y.isEmpty(list)) {
                GodSquareActivity.this.jXD.cOq();
                if (y.isEmpty(GodSquareActivity.this.jXE.jcx)) {
                    GodSquareActivity.this.jXD.Ka(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.isNetOk()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.jXD.WZ();
            if (z) {
                GodSquareActivity.this.jXE.jcx = list;
                GodSquareActivity.this.jXD.dM(GodSquareActivity.this.jXE.jcx);
            } else {
                GodSquareActivity.this.jXE.jcx.addAll(list);
                GodSquareActivity.this.jXD.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.jXD.cOp();
            } else {
                GodSquareActivity.this.jXD.cOr();
            }
        }
    };
    private CustomMessageListener faJ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.godSquare.GodSquareActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (GodSquareActivity.this.jXE.gB(com.baidu.adp.lib.f.b.toLong(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.jXF = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a gyn = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                if (y.isEmpty(GodSquareActivity.this.jXE.jcx)) {
                    GodSquareActivity.this.cOo();
                } else {
                    GodSquareActivity.this.jXD.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jXD = new a(this);
        this.jXD.f(this.gyn);
        this.jXE = new b(this.jXG, this);
        registerListener(this.faJ);
        cOo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jXD.notifyDataSetChanged();
        if (this.jXF) {
            this.jXD.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cOo() {
        this.jXD.showLoadingView();
        this.jXE.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            cOo();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jXD.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.jXF = false;
        this.jXE.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.jXE.bRj();
            this.jXD.cOp();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.GOD_SQUARE;
    }
}
