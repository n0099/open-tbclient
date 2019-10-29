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
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes6.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, h.c {
    private a gce;
    private b gcf;
    private boolean mHasMore = true;
    private boolean gcg = false;
    private b.a gch = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<m> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.gce.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.gce.hideLoadingView();
            if (v.isEmpty(list)) {
                GodSquareActivity.this.gce.bsz();
                if (v.isEmpty(GodSquareActivity.this.gcf.frK)) {
                    GodSquareActivity.this.gce.vG(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.isNetOk()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.gce.aJo();
            if (z) {
                GodSquareActivity.this.gcf.frK = list;
                GodSquareActivity.this.gce.cK(GodSquareActivity.this.gcf.frK);
            } else {
                GodSquareActivity.this.gcf.frK.addAll(list);
                GodSquareActivity.this.gce.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.gce.bsy();
            } else {
                GodSquareActivity.this.gce.bsA();
            }
        }
    };
    private CustomMessageListener cjZ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.godSquare.GodSquareActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (GodSquareActivity.this.gcf.cR(com.baidu.adp.lib.g.b.toLong(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.gcg = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a eRC = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                if (v.isEmpty(GodSquareActivity.this.gcf.frK)) {
                    GodSquareActivity.this.bsx();
                } else {
                    GodSquareActivity.this.gce.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gce = new a(this);
        this.gce.g(this.eRC);
        this.gcf = new b(this.gch, this);
        registerListener(this.cjZ);
        bsx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gce.notifyDataSetChanged();
        if (this.gcg) {
            this.gce.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsx() {
        this.gce.showLoadingView();
        this.gcf.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            bsx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gce.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        this.gcg = false;
        this.gcf.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.gcf.aIW();
            this.gce.bsy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.GOD_SQUARE;
    }
}
