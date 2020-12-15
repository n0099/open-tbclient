package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes24.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, f.c {
    private a jHa;
    private b jHb;
    private boolean mHasMore = true;
    private boolean jHc = false;
    private b.a jHd = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<q> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.jHa.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.jHa.hideLoadingView();
            if (y.isEmpty(list)) {
                GodSquareActivity.this.jHa.cMQ();
                if (y.isEmpty(GodSquareActivity.this.jHb.iOX)) {
                    GodSquareActivity.this.jHa.KC(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.isNetOk()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.jHa.Yb();
            if (z) {
                GodSquareActivity.this.jHb.iOX = list;
                GodSquareActivity.this.jHa.dH(GodSquareActivity.this.jHb.iOX);
            } else {
                GodSquareActivity.this.jHb.iOX.addAll(list);
                GodSquareActivity.this.jHa.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.jHa.cMP();
            } else {
                GodSquareActivity.this.jHa.cMR();
            }
        }
    };
    private CustomMessageListener eTG = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.godSquare.GodSquareActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (GodSquareActivity.this.jHb.gw(com.baidu.adp.lib.f.b.toLong(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.jHc = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a gpz = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                if (y.isEmpty(GodSquareActivity.this.jHb.iOX)) {
                    GodSquareActivity.this.cMO();
                } else {
                    GodSquareActivity.this.jHa.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jHa = new a(this);
        this.jHa.f(this.gpz);
        this.jHb = new b(this.jHd, this);
        registerListener(this.eTG);
        cMO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jHa.notifyDataSetChanged();
        if (this.jHc) {
            this.jHa.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cMO() {
        this.jHa.showLoadingView();
        this.jHb.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            cMO();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jHa.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.jHc = false;
        this.jHb.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.jHb.bRN();
            this.jHa.cMP();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.GOD_SQUARE;
    }
}
