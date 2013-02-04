package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.c.ae;
import com.baidu.tieba.c.ag;
/* loaded from: classes.dex */
public class e extends Activity {
    protected ProgressDialog a = null;
    private DialogInterface.OnCancelListener b = null;
    private AlertDialog c = null;

    /* JADX INFO: Access modifiers changed from: protected */
    public AlertDialog a(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.operation);
        builder.setItems(strArr, onClickListener);
        this.c = builder.create();
        this.c.setCanceledOnTouchOutside(true);
        return this.c;
    }

    public void a() {
    }

    public void a(View view, int i) {
        new Handler().postDelayed(new g(this, view), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(InputMethodManager inputMethodManager, View view) {
        try {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e) {
            ae.b(getClass().getName(), "HidenSoftKeyPad", "error = " + e.getMessage());
        }
    }

    public void a(String str) {
        if (this.b == null) {
            this.b = new f(this);
        }
        if (str != null) {
            this.a = ProgressDialog.show(this, "", str, true, false, this.b);
        } else {
            this.a = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, false, this.b);
        }
    }

    public void a(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.a = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.a = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, true, onCancelListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlertDialog b(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        return this.c != null ? this.c : a(strArr, onClickListener);
    }

    public void b() {
        this.a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(InputMethodManager inputMethodManager, View view) {
        if (view == null || inputMethodManager == null) {
            return;
        }
        try {
            inputMethodManager.showSoftInput(view, 0);
        } catch (Exception e) {
        }
    }

    public void b(String str) {
        ag.a((Context) this, str);
    }

    public void c() {
        if (this.a != null) {
            try {
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            } catch (Exception e) {
                ae.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlertDialog d() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        if (this.c == null || this.c.isShowing()) {
            return;
        }
        this.c.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f() {
        ag.a((Activity) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.account.a.a().c();
        TiebaApplication.o(true);
        TiebaApplication.a().a(getClass().getName());
        if (TiebaApplication.a().i()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.a.h.a());
            } catch (Exception e) {
                ae.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        c();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        TiebaApplication.a().am();
        if (TiebaApplication.a().i()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                ae.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        ag.e(this);
        super.onResume();
        if (TiebaApplication.a().i()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                ae.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TiebaApplication.a().al();
        TiebaApplication.a().a(getClass().getName());
    }
}
