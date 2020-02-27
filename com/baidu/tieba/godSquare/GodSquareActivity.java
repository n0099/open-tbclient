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
    private a gUL;
    private b gUM;
    private boolean mHasMore = true;
    private boolean gUN = false;
    private b.a gUO = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<m> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.gUL.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.gUL.hideLoadingView();
            if (v.isEmpty(list)) {
                GodSquareActivity.this.gUL.bMz();
                if (v.isEmpty(GodSquareActivity.this.gUM.gkA)) {
                    GodSquareActivity.this.gUL.AY(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.isNetOk()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.gUL.bcv();
            if (z) {
                GodSquareActivity.this.gUM.gkA = list;
                GodSquareActivity.this.gUL.cz(GodSquareActivity.this.gUM.gkA);
            } else {
                GodSquareActivity.this.gUM.gkA.addAll(list);
                GodSquareActivity.this.gUL.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.gUL.bMy();
            } else {
                GodSquareActivity.this.gUL.bMA();
            }
        }
    };
    private CustomMessageListener dae = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.godSquare.GodSquareActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (GodSquareActivity.this.gUM.dB(com.baidu.adp.lib.f.b.toLong(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.gUN = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a fYJ = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                if (v.isEmpty(GodSquareActivity.this.gUM.gkA)) {
                    GodSquareActivity.this.bMx();
                } else {
                    GodSquareActivity.this.gUL.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.gUL = new a(this);
        this.gUL.f(this.fYJ);
        this.gUM = new b(this.gUO, this);
        registerListener(this.dae);
        bMx();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.gUL.notifyDataSetChanged();
        if (this.gUN) {
            this.gUL.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMx() {
        this.gUL.showLoadingView();
        this.gUM.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            bMx();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.gUL.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.g.c
    public void onListPullRefresh(boolean z) {
        this.gUN = false;
        this.gUM.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.gUM.bcd();
            this.gUL.bMy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.GOD_SQUARE;
    }
}
