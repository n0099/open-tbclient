package com.baidu.tieba;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.view.GuidPageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.a.a {
    protected ProgressDialog h = null;

    /* renamed from: a  reason: collision with root package name */
    private DialogInterface.OnCancelListener f879a = null;
    private AlertDialog b = null;
    protected int i = -1;
    private GuidPageView c = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (e()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        com.baidu.tieba.account.a.a().c();
        TiebaApplication.t(true);
        TiebaApplication.f().a(getClass().getName());
        if (TiebaApplication.f().t()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.g.a());
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    public boolean e() {
        return false;
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
    public void f() {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onDestroy() {
        h();
        if (this.c != null) {
            this.c.a();
        }
        super.onDestroy();
    }

    @Override // com.baidu.adp.a.a
    public void a_() {
    }

    public void b(String str) {
        if (this.f879a == null) {
            this.f879a = new h(this);
        }
        if (str != null) {
            this.h = ProgressDialog.show(this, "", str, true, false, this.f879a);
        } else {
            this.h = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, false, this.f879a);
        }
    }

    public void g() {
        this.h = null;
    }

    public void a(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.h = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.h = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, true, onCancelListener);
        }
    }

    public void h() {
        if (this.h != null) {
            try {
                if (this.h.isShowing()) {
                    this.h.dismiss();
                }
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.h = null;
        }
    }

    @Override // com.baidu.adp.a.a
    public void a(String str) {
        com.baidu.tieba.util.ab.a((Context) this, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(InputMethodManager inputMethodManager, View view) {
        try {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e) {
            com.baidu.tieba.util.z.b(getClass().getName(), "HidenSoftKeyPad", "error = " + e.getMessage());
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
        new Handler().postDelayed(new i(this, view), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlertDialog a(String[] strArr, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.operation);
        builder.setItems(strArr, onClickListener);
        this.b = builder.create();
        this.b.setCanceledOnTouchOutside(true);
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AlertDialog i() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        if (this.b != null && !this.b.isShowing()) {
            this.b.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        TiebaApplication.f().aG();
        if (TiebaApplication.f().t()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i) {
        this.i = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.f().at() != this.i) {
            this.i = TiebaApplication.f().at();
            a(this.i);
        }
        if (TiebaApplication.f().t()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.tieba.util.z.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TiebaApplication.f().aF();
        TiebaApplication.f().a(getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        com.baidu.tieba.util.ab.a((Activity) this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, int i2) {
        Bitmap b;
        if (!TiebaApplication.f().b(i2)) {
            this.c = (GuidPageView) getLayoutInflater().inflate(R.layout.guid_page, (ViewGroup) null);
            if (this.c != null && (b = com.baidu.tieba.util.d.b(this, i)) != null) {
                this.c.setBackgroundDrawable(new BitmapDrawable(b));
                addContentView(this.c, new FrameLayout.LayoutParams(-1, -1));
                TiebaApplication.f().c(i2);
            }
        } else if (this.c != null) {
            this.c.setVisibility(8);
        }
    }
}
