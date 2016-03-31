package com.baidu.tieba.godSquare;

import android.os.Bundle;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.godSquare.model.b;
/* loaded from: classes.dex */
public class GodSquareActivity extends BaseActivity<GodSquareActivity> implements BdListView.e, s.a {
    private d bJU;
    private com.baidu.tieba.godSquare.model.b bJV;
    private boolean mHasMore = true;
    private boolean bJW = false;
    private b.a bJX = new a(this);
    private CustomMessageListener ahZ = new b(this, CmdConfigCustom.CMD_UPDATE_ATTENTION);
    private NoNetworkView.a bfk = new c(this);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bJU = new d(this);
        this.bJU.h(this.bfk);
        this.bJV = new com.baidu.tieba.godSquare.model.b(this.bJX, this);
        registerListener(this.ahZ);
        XW();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.bJU.notifyDataSetChanged();
        if (this.bJW) {
            this.bJU.nk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void XW() {
        this.bJU.Ql();
        this.bJV.update();
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        if (i.iT()) {
            XW();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bJU.onChangeSkinType(i);
    }

    @Override // com.baidu.tbadk.core.view.s.a
    public void aB(boolean z) {
        this.bJW = false;
        this.bJV.update();
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nm() {
        if (this.mHasMore) {
            this.bJV.Qq();
            this.bJU.Ya();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.tbadk.pageStayDuration.a
    public String getCurrentPageKey() {
        return "a009";
    }
}
