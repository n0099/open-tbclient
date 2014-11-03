package com.baidu.tbadk.mvc.core;

import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.mvc.core.a;
import com.baidu.tbadk.mvc.core.c;
/* loaded from: classes.dex */
public abstract class MvcActivity<V extends c, M extends a> extends BaseActivity implements com.baidu.tbadk.mvc.c.a {
    private ViewEventCenter Xo;
    private M Xp;
    private V Xq;

    protected abstract M tl();

    protected abstract V tm();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.Xp = tl();
        if (this.Xp != null) {
            this.Xp.setUniqueId(getUniqueId());
            this.Xp.a(this);
        }
        this.Xq = tm();
        if (this.Xq != null) {
            this.Xq.setUniqueId(getUniqueId());
            this.Xq.a(this);
        }
        this.Xo = ta();
        setContentView(this.Xq.th());
        this.Xq.ti();
        this.Xq.tf();
        if (getIntent() != null) {
            this.Xp.b(getIntent().getExtras());
            this.Xq.c(getIntent().getExtras());
        } else if (bundle != null) {
            this.Xp.b(bundle);
            this.Xq.c(bundle);
        } else {
            this.Xp.b(null);
            this.Xq.c(null);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        tm().nv();
    }

    @Override // android.app.Activity
    protected void onRestart() {
        super.onRestart();
        tm().tc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        tm().td();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        tm().te();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        tm().onActivityStop();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        tm().onActivityDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.Xp.onSaveInstanceState(bundle);
        this.Xq.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        tm().onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.Xq.dg(i);
    }

    public ViewEventCenter ta() {
        if (this.Xo == null) {
            this.Xo = new ViewEventCenter();
        }
        return this.Xo;
    }

    @Override // com.baidu.tbadk.mvc.c.a
    public boolean tk() {
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
