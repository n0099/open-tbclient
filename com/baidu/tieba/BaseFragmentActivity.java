package com.baidu.tieba;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
public abstract class BaseFragmentActivity extends android.support.v4.app.n {
    protected ProgressDialog a = null;
    private DialogInterface.OnCancelListener b = null;
    private AlertDialog c = null;
    private int d = -1;
    private e e;

    protected abstract void a(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.account.l.a().c();
        TiebaApplication.v(true);
        TiebaApplication.h().a(getClass().getName());
        this.e = new e();
        if (TiebaApplication.h().t()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.h.a());
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.h().an() != this.d) {
            this.d = TiebaApplication.h().an();
            a(this.d);
        }
        if (TiebaApplication.h().t()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TiebaApplication.h().aA();
        TiebaApplication.h().a(getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onPause() {
        super.onPause();
        TiebaApplication.h().aB();
        if (TiebaApplication.h().t()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onDestroy() {
        if (this.e != null) {
            this.e.b();
        }
        super.onDestroy();
    }

    public e a() {
        return this.e;
    }

    public void a(String str) {
        com.baidu.adp.lib.h.g.a((Context) this, str);
    }

    public void b(int i) {
        com.baidu.adp.lib.h.g.a((Context) this, i);
    }

    @Override // android.support.v4.app.n, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.e == null) {
            this.e = new e();
        }
        this.e.a(str, context, attributeSet);
        return super.onCreateView(str, context, attributeSet);
    }
}
