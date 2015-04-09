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
    private M LE;
    private ViewEventCenter amv;
    private V amw;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Aq();
        this.LE = oi();
        if (this.LE != null) {
            this.LE.setUniqueId(getUniqueId());
            this.LE.a(this);
        }
        this.amw = ok();
        if (this.amw != null) {
            this.amw.setUniqueId(getUniqueId());
            this.amw.a(this);
        }
        this.amv = zZ();
        Ar();
        As();
        if (getIntent() != null) {
            this.LE.f(getIntent().getExtras());
            this.amw.h(getIntent().getExtras());
        } else if (bundle != null) {
            this.LE.f(bundle);
            this.amw.h(bundle);
        } else {
            this.LE.f(null);
            this.amw.h(null);
        }
        At();
        Au();
        setContentView(this.amw.Ap());
        this.amw.ov();
        this.amw.a(getPageContext(), TbadkCoreApplication.m411getInst().getSkinType());
        this.amw.Am();
        Av();
    }

    protected void Aq() {
    }

    protected void Ar() {
    }

    protected void As() {
    }

    protected void At() {
    }

    protected void Au() {
    }

    protected void Av() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        Aw();
        ok().Ac();
    }

    protected void Aw() {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        Ax();
        ok().Ad();
    }

    protected void Ax() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        Ay();
        ok().Af();
    }

    protected void Ay() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        Az();
        ok().Ah();
    }

    protected void Az() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        AA();
        ok().Aj();
    }

    protected void AA() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AB();
        ok().Ak();
    }

    protected void AB() {
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
        this.LE.onSaveInstanceState(bundle);
        this.amw.onSaveInstanceState(bundle);
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
        this.amw.a(getPageContext(), i);
    }

    @Override // com.baidu.tbadk.mvc.core.e
    public ViewEventCenter zZ() {
        if (this.amv == null) {
            this.amv = new ViewEventCenter();
        }
        return this.amv;
    }

    protected void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean Aa() {
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
