package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.mobstat.StatService;
/* loaded from: classes.dex */
public class e extends Activity {
    protected ProgressDialog a = null;
    private DialogInterface.OnCancelListener c = null;
    private AlertDialog d = null;
    protected int b = -1;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.account.a.a().c();
        TiebaApplication.p(true);
        TiebaApplication.b().a(getClass().getName());
        if (TiebaApplication.b().l()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.a.i.a());
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyDown(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            return super.onKeyUp(i, keyEvent);
        } catch (IllegalStateException e) {
            if (i == 4) {
                finish();
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        d();
        super.onDestroy();
    }

    public void b() {
    }

    public void a(String str) {
        if (this.c == null) {
            this.c = new f(this);
        }
        if (str != null) {
            this.a = ProgressDialog.show(this, "", str, true, false, this.c);
        } else {
            this.a = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, false, this.c);
        }
    }

    public void c() {
        this.a = null;
    }

    public void a(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.a = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.a = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, true, onCancelListener);
        }
    }

    public void d() {
        if (this.a != null) {
            try {
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.a = null;
        }
    }

    public void b(String str) {
        com.baidu.tieba.c.ai.a((Context) this, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(InputMethodManager inputMethodManager, View view) {
        try {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "HidenSoftKeyPad", "error = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(InputMethodManager inputMethodManager, View view) {
        if (view != null && inputMethodManager != null) {
            try {
                inputMethodManager.showSoftInput(view, 0);
            } catch (Exception e) {
            }
        }
    }

    public void a(View view, int i) {
        new Handler().postDelayed(new g(this, view), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlertDialog a(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.operation);
        builder.setItems(strArr, onClickListener);
        this.d = builder.create();
        this.d.setCanceledOnTouchOutside(true);
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlertDialog b(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        return this.d != null ? this.d : a(strArr, onClickListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlertDialog e() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        if (this.d != null && !this.d.isShowing()) {
            this.d.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        TiebaApplication.b().av();
        if (TiebaApplication.b().l()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a_(int i) {
        this.b = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.b().ah() != this.b) {
            this.b = TiebaApplication.b().ah();
            b(this.b);
        }
        if (TiebaApplication.b().l()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TiebaApplication.b().au();
        TiebaApplication.b().a(getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h() {
        com.baidu.tieba.c.ai.a((Activity) this);
    }
}
