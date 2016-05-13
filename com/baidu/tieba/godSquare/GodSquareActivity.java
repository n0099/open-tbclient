package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.godSquare.model.b;
/* loaded from: classes.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, t.b {
    private d bKa;
    private com.baidu.tieba.godSquare.model.b bKb;
    private boolean mHasMore = true;
    private boolean bKc = false;
    private b.a bKd = new a(this);
    private CustomMessageListener adW = new b(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private NoNetworkView.a baZ = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bKa = new d(this);
        this.bKa.f(this.baZ);
        this.bKb = new com.baidu.tieba.godSquare.model.b(this.bKd, this);
        registerListener(this.adW);
        XW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bKa.notifyDataSetChanged();
        if (this.bKc) {
            this.bKa.jy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XW() {
        this.bKa.Pe();
        this.bKb.update();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (i.fe()) {
            XW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bKa.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aG(boolean z) {
        this.bKc = false;
        this.bKb.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void jA() {
        if (this.mHasMore) {
            this.bKb.Pp();
            this.bKa.XX();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
