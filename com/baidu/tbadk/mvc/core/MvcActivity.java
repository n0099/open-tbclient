package com.baidu.tbadk.mvc.core;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.mvc.core.a;
import com.baidu.tbadk.mvc.core.c;
/* loaded from: classes.dex */
public abstract class MvcActivity<V extends c, M extends a> extends BaseActivity implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter Xk;
    private M Xl;
    private V Xm;

    protected abstract M tj();

    protected abstract V tk();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Xl = tj();
        if (this.Xl != null) {
            this.Xl.setUniqueId(getUniqueId());
            this.Xl.a(this);
        }
        this.Xm = tk();
        if (this.Xm != null) {
            this.Xm.setUniqueId(getUniqueId());
            this.Xm.a(this);
        }
        this.Xk = sY();
        setContentView(this.Xm.tf());
        this.Xm.tg();
        this.Xm.td();
        if (getIntent() != null) {
            this.Xl.b(getIntent().getExtras());
            this.Xm.c(getIntent().getExtras());
        } else if (bundle != null) {
            this.Xl.b(bundle);
            this.Xm.c(bundle);
        } else {
            this.Xl.b(null);
            this.Xm.c(null);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        tk().nv();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        tk().ta();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        tk().tb();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        tk().tc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        tk().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        tk().onActivityDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.Xl.onSaveInstanceState(bundle);
        this.Xm.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        tk().onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.Xm.dg(i);
    }

    public ViewEventCenter sY() {
        if (this.Xk == null) {
            this.Xk = new ViewEventCenter();
        }
        return this.Xk;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean ti() {
        return false;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean a(com.baidu.tbadk.mvc.c.b bVar) {
        if (bVar == null) {
            return true;
        }
        if (bVar instanceof com.baidu.tbadk.mvc.c.b.a) {
            com.baidu.tbadk.mvc.c.b.a aVar = (com.baidu.tbadk.mvc.c.b.a) bVar;
            if (aVar.getExtra() == null || !StringUtils.isNull(aVar.getExtra().error_msg)) {
                return true;
            }
            showToast(aVar.getExtra().error_msg);
            return true;
        }
        return false;
    }
}
