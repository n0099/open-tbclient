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
    private a gbn;
    private b gbo;
    private boolean mHasMore = true;
    private boolean gbp = false;
    private b.a gbq = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<m> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.gbn.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.gbn.hideLoadingView();
            if (v.isEmpty(list)) {
                GodSquareActivity.this.gbn.bsx();
                if (v.isEmpty(GodSquareActivity.this.gbo.fqS)) {
                    GodSquareActivity.this.gbn.vG(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.isNetOk()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.gbn.aJm();
            if (z) {
                GodSquareActivity.this.gbo.fqS = list;
                GodSquareActivity.this.gbn.cK(GodSquareActivity.this.gbo.fqS);
            } else {
                GodSquareActivity.this.gbo.fqS.addAll(list);
                GodSquareActivity.this.gbn.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.gbn.bsw();
            } else {
                GodSquareActivity.this.gbn.bsy();
            }
        }
    };
    private CustomMessageListener cji = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.godSquare.GodSquareActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (GodSquareActivity.this.gbo.cQ(com.baidu.adp.lib.g.b.toLong(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.gbp = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a eQL = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                if (v.isEmpty(GodSquareActivity.this.gbo.fqS)) {
                    GodSquareActivity.this.bsv();
                } else {
                    GodSquareActivity.this.gbn.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gbn = new a(this);
        this.gbn.g(this.eQL);
        this.gbo = new b(this.gbq, this);
        registerListener(this.cji);
        bsv();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gbn.notifyDataSetChanged();
        if (this.gbp) {
            this.gbn.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsv() {
        this.gbn.showLoadingView();
        this.gbo.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            bsv();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gbn.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void onListPullRefresh(boolean z) {
        this.gbp = false;
        this.gbo.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.gbo.aIU();
            this.gbn.bsw();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.GOD_SQUARE;
    }
}
