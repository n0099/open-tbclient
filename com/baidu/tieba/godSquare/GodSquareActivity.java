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
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.f;
import com.baidu.tbadk.coreExtra.message.UpdateAttentionMessage;
import com.baidu.tieba.godSquare.model.b;
import java.util.List;
/* loaded from: classes18.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, f.c {
    private a iqa;
    private b iqb;
    private boolean mHasMore = true;
    private boolean iqc = false;
    private b.a iqd = new b.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.1
        @Override // com.baidu.tieba.godSquare.model.b.a
        public void a(List<q> list, boolean z, boolean z2, String str) {
            GodSquareActivity.this.mHasMore = z2;
            GodSquareActivity.this.iqa.getListView().completePullRefreshPostDelayed(0L);
            GodSquareActivity.this.iqa.hideLoadingView();
            if (x.isEmpty(list)) {
                GodSquareActivity.this.iqa.ckT();
                if (x.isEmpty(GodSquareActivity.this.iqb.hBA)) {
                    GodSquareActivity.this.iqa.FJ(str);
                    return;
                }
                GodSquareActivity.this.mHasMore = true;
                if (l.isNetOk()) {
                    GodSquareActivity.this.showToast(str);
                    return;
                }
                return;
            }
            GodSquareActivity.this.iqa.bwX();
            if (z) {
                GodSquareActivity.this.iqb.hBA = list;
                GodSquareActivity.this.iqa.cX(GodSquareActivity.this.iqb.hBA);
            } else {
                GodSquareActivity.this.iqb.hBA.addAll(list);
                GodSquareActivity.this.iqa.notifyDataSetChanged();
            }
            if (z2) {
                GodSquareActivity.this.iqa.ckS();
            } else {
                GodSquareActivity.this.iqa.ckU();
            }
        }
    };
    private CustomMessageListener eaY = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.godSquare.GodSquareActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof UpdateAttentionMessage) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && !StringUtils.isNull(updateAttentionMessage.getData().toUid)) {
                    if (GodSquareActivity.this.iqb.eB(com.baidu.adp.lib.f.b.toLong(updateAttentionMessage.getData().toUid, 0L))) {
                        GodSquareActivity.this.iqc = true;
                    }
                }
            }
        }
    };
    private NoNetworkView.a fqT = new NoNetworkView.a() { // from class: com.baidu.tieba.godSquare.GodSquareActivity.3
        @Override // com.baidu.tbadk.core.view.NoNetworkView.a
        public void onNetworkChange(boolean z) {
            if (z) {
                if (x.isEmpty(GodSquareActivity.this.iqb.hBA)) {
                    GodSquareActivity.this.ckR();
                } else {
                    GodSquareActivity.this.iqa.startPullRefresh();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iqa = new a(this);
        this.iqa.f(this.fqT);
        this.iqb = new b(this.iqd, this);
        registerListener(this.eaY);
        ckR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.iqa.notifyDataSetChanged();
        if (this.iqc) {
            this.iqa.startPullRefresh();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckR() {
        this.iqa.showLoadingView();
        this.iqb.update();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        if (j.isNetworkAvailableForImmediately()) {
            ckR();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.iqa.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.f.c
    public void onListPullRefresh(boolean z) {
        this.iqc = false;
        this.iqb.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        if (this.mHasMore) {
            this.iqb.bwE();
            this.iqa.ckS();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.GOD_SQUARE;
    }
}
