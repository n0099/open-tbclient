package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.hottopic.controller.d;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class HotRanklistActivity extends BaseActivity<HotTopicActivity> implements d.a {
    private com.baidu.tieba.hottopic.view.b bJT;
    private d bJU;
    private String bJV = "";
    private String bJW = "";
    private long bJX = System.currentTimeMillis();
    private com.baidu.tieba.hottopic.data.i ranklistData;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        g(bundle);
        qD();
        Xr();
        Xt();
    }

    private void g(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null) {
            this.bJV = intent.getStringExtra(IntentConfig.CALL_FROM);
            this.bJW = intent.getStringExtra(IntentConfig.LIST_TYPE);
        } else if (bundle != null) {
            this.bJV = bundle.getString(IntentConfig.CALL_FROM);
            this.bJW = bundle.getString(IntentConfig.LIST_TYPE);
        }
    }

    private void qD() {
        this.bJT = new com.baidu.tieba.hottopic.view.b(this);
        this.bJU = new d(this);
        this.bJU.a(this);
    }

    private void Xr() {
        this.bJT.a(new b(this));
        this.bJT.f(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xs() {
        if (!com.baidu.adp.lib.util.i.iZ()) {
            this.bJT.Ya();
        } else if (this.bJU != null) {
            this.bJU.aD(this.bJV, this.bJW);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bJT.onChangeSkinType(i);
        changeSkinType(i);
    }

    @Override // com.baidu.tbadk.BaseActivity
    protected void onNetRefreshButtonClicked() {
        hideNetRefreshView(this.bJT.Yb());
        Xt();
    }

    @Override // com.baidu.tieba.hottopic.controller.d.a
    public void a(boolean z, com.baidu.tieba.hottopic.data.i iVar) {
        this.bJT.Ya();
        hideLoadingView(this.bJT.Yb());
        if (!z || iVar == null || this.bJT == null) {
            showNetRefreshView(this.bJT.Yb(), null);
            return;
        }
        this.ranklistData = iVar;
        this.bJT.b(iVar);
        this.bJT.Yc();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (!StringUtils.isNull(this.bJV) || !StringUtils.isNull(this.bJW)) {
            bundle.putString(IntentConfig.CALL_FROM, this.bJV);
            bundle.putString(IntentConfig.LIST_TYPE, this.bJW);
        }
    }

    private void Xt() {
        showLoadingView(this.bJT.Yb(), true);
        if (!com.baidu.adp.lib.util.i.iZ()) {
            hideLoadingView(this.bJT.Yb());
            showNetRefreshView(this.bJT.Yb(), getResources().getString(t.j.neterror), true);
            this.bJT.iA(0);
            return;
        }
        Xs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Xu();
    }

    private void Xu() {
        if (this.bJT != null) {
            this.bJT.Yd();
            this.bJT.Ye();
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: long : 0x0009: ARITH  (r0v1 long A[REMOVE]) = (wrap: long : 0x0003: INVOKE  (r0v0 long A[REMOVE]) =  type: STATIC call: java.lang.System.currentTimeMillis():long) - (wrap: long : 0x0007: IGET  (r2v0 long A[REMOVE]) = (r5v0 'this' com.baidu.tieba.hottopic.controller.HotRanklistActivity A[IMMUTABLE_TYPE, THIS]) com.baidu.tieba.hottopic.controller.HotRanklistActivity.bJX long))] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TiebaStatic.log(new au("c10818").aa("obj_duration", new StringBuilder().append(System.currentTimeMillis() - this.bJX).toString()));
    }
}
