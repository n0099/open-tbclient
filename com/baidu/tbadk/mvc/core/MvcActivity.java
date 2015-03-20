package com.baidu.tbadk.mvc.core;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.mvc.core.a;
import com.baidu.tbadk.mvc.core.c;
/* loaded from: classes.dex */
public abstract class MvcActivity<V extends c, M extends a, T> extends BaseActivity<T> implements com.baidu.tbadk.mvc.c.a, e<V, M, T> {
    private M LB;
    private ViewEventCenter amn;
    private V amo;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Ak();
        this.LB = oi();
        if (this.LB != null) {
            this.LB.setUniqueId(getUniqueId());
            this.LB.a(this);
        }
        this.amo = ok();
        if (this.amo != null) {
            this.amo.setUniqueId(getUniqueId());
            this.amo.a(this);
        }
        this.amn = zT();
        Al();
        Am();
        if (getIntent() != null) {
            this.LB.f(getIntent().getExtras());
            this.amo.h(getIntent().getExtras());
        } else if (bundle != null) {
            this.LB.f(bundle);
            this.amo.h(bundle);
        } else {
            this.LB.f(null);
            this.amo.h(null);
        }
        An();
        Ao();
        setContentView(this.amo.Aj());
        this.amo.ov();
        this.amo.a(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.amo.Ag();
        Ap();
    }

    protected void Ak() {
    }

    protected void Al() {
    }

    protected void Am() {
    }

    protected void An() {
    }

    protected void Ao() {
    }

    protected void Ap() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        Aq();
        ok().zW();
    }

    protected void Aq() {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        Ar();
        ok().zX();
    }

    protected void Ar() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        As();
        ok().zZ();
    }

    protected void As() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        At();
        ok().Ab();
    }

    protected void At() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        Au();
        ok().Ad();
    }

    protected void Au() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Av();
        ok().Ae();
    }

    protected void Av() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.LB.onSaveInstanceState(bundle);
        this.amo.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ok().onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.amo.a(getPageContext(), i);
    }

    @Override // com.baidu.tbadk.mvc.core.e
    public ViewEventCenter zT() {
        if (this.amn == null) {
            this.amn = new ViewEventCenter();
        }
        return this.amn;
    }

    protected void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean zU() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar instanceof com.baidu.tbadk.mvc.c.b.a) {
            a(((com.baidu.tbadk.mvc.c.b.a) bVar).getExtra());
            return true;
        }
        return false;
    }
}
