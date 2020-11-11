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
    private a jsR;
    private b jsS;
    private boolean mHasMore = true;
    private boolean jsT = false;
    private b.a jsU = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<q> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.jsR.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.jsR.hideLoadingView();
            if (y.isEmpty(list)) {
                GodSquareActivity.this.jsR.cHW();
                if (y.isEmpty(GodSquareActivity.this.jsS.iDp)) {
                    GodSquareActivity.this.jsR.Kl(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.isNetOk()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.jsR.Wk();
            if (z) {
                GodSquareActivity.this.jsS.iDp = list;
                GodSquareActivity.this.jsR.dy(GodSquareActivity.this.jsS.iDp);
            } else {
                GodSquareActivity.this.jsS.iDp.addAll(list);
                GodSquareActivity.this.jsR.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.jsR.cHV();
            } else {
                GodSquareActivity.this.jsR.cHX();
            }
        }
    };
    private CustomMessageListener eNv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.godSquare.GodSquareActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (GodSquareActivity.this.jsS.fO(com.baidu.adp.lib.f.b.toLong(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.jsT = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a ghG = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                if (y.isEmpty(GodSquareActivity.this.jsS.iDp)) {
                    GodSquareActivity.this.cHU();
                } else {
                    GodSquareActivity.this.jsR.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jsR = new a(this);
        this.jsR.f(this.ghG);
        this.jsS = new b(this.jsU, this);
        registerListener(this.eNv);
        cHU();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.jsR.notifyDataSetChanged();
        if (this.jsT) {
            this.jsR.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHU() {
        this.jsR.showLoadingView();
        this.jsS.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            cHU();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jsR.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.jsT = false;
        this.jsS.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.jsS.bOI();
            this.jsR.cHV();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.GOD_SQUARE;
    }
}
