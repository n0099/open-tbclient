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
    private ViewEventCenter adW;
    private V adX;
    private M zc;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        xe();
        this.zc = kw();
        if (this.zc != null) {
            this.zc.setUniqueId(getUniqueId());
            this.zc.a(this);
        }
        this.adX = ky();
        if (this.adX != null) {
            this.adX.setUniqueId(getUniqueId());
            this.adX.a(this);
        }
        this.adW = wN();
        xf();
        xg();
        if (getIntent() != null) {
            this.zc.f(getIntent().getExtras());
            this.adX.i(getIntent().getExtras());
        } else if (bundle != null) {
            this.zc.f(bundle);
            this.adX.i(bundle);
        } else {
            this.zc.f(null);
            this.adX.i(null);
        }
        xh();
        xi();
        setContentView(this.adX.xd());
        this.adX.kJ();
        this.adX.a(getPageContext(), TbadkCoreApplication.m255getInst().getSkinType());
        this.adX.xa();
        xj();
    }

    protected void xe() {
    }

    protected void xf() {
    }

    protected void xg() {
    }

    protected void xh() {
    }

    protected void xi() {
    }

    protected void xj() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        xk();
        ky().wQ();
    }

    protected void xk() {
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        xl();
        ky().wR();
    }

    protected void xl() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        xm();
        ky().wT();
    }

    protected void xm() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        xn();
        ky().wV();
    }

    protected void xn() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        xo();
        ky().wX();
    }

    protected void xo() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        xp();
        ky().wY();
    }

    protected void xp() {
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.zc.onSaveInstanceState(bundle);
        this.adX.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        ky().onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        this.adX.a(getPageContext(), i);
    }

    @Override // com.baidu.tbadk.mvc.core.e
    public ViewEventCenter wN() {
        if (this.adW == null) {
            this.adW = new ViewEventCenter();
        }
        return this.adW;
    }

    protected void a(ErrorData errorData) {
        if (errorData != null && !StringUtils.isNull(errorData.error_msg)) {
            showToast(errorData.error_msg);
        }
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean wO() {
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
