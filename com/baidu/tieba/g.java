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
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.home.EnterForumActivity;
import com.baidu.tieba.pb.NewPbActivity;
import com.baidu.tieba.view.GuidPageView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.a.a {
    protected ProgressDialog h = null;

    /* renamed from: a  reason: collision with root package name */
    private DialogInterface.OnCancelListener f1101a = null;
    private AlertDialog b = null;
    protected int i = -1;
    private GuidPageView c = null;
    private long d = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.d = System.currentTimeMillis();
        super.onCreate(bundle);
        if (e()) {
            CompatibleUtile.getInstance().openGpu(this);
        }
        com.baidu.tieba.account.a.a().c();
        TiebaApplication.u(true);
        TiebaApplication.f().a(getClass().getName());
        if (TiebaApplication.f().t()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.g.a());
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "onCreate", e.getMessage());
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
        if (this.f1101a == null) {
            this.f1101a = new h(this);
        }
        if (str != null) {
            this.h = ProgressDialog.show(this, "", str, true, false, this.f1101a);
        } else {
            this.h = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, false, this.f1101a);
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
                com.baidu.tieba.util.aj.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.h = null;
        }
    }

    @Override // com.baidu.adp.a.a
    public void a(String str) {
        com.baidu.tieba.util.am.a((Context) this, str);
    }

    public void c(int i) {
        com.baidu.tieba.util.am.a((Context) this, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(InputMethodManager inputMethodManager, View view) {
        try {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        } catch (Exception e) {
            com.baidu.tieba.util.aj.b(getClass().getName(), "HidenSoftKeyPad", "error = " + e.getMessage());
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
    @Override // android.app.Activity
    public void onPause() {
        super.onPause();
        TiebaApplication.f().aK();
        if (TiebaApplication.f().t()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(int i) {
        this.i = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.f().au() != this.i) {
            this.i = TiebaApplication.f().au();
            a(this.i);
        }
        if (TiebaApplication.f().t()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.tieba.util.aj.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TiebaApplication.f().aJ();
        TiebaApplication.f().a(getClass().getName());
        if (this.d > 0) {
            this.d = System.currentTimeMillis() - this.d;
            if (this.d < 5000) {
                String str = null;
                if (this instanceof NewPbActivity) {
                    str = "op_pb_enter";
                } else if (this instanceof FrsActivity) {
                    str = "op_frs_enter";
                } else if (this instanceof EnterForumActivity) {
                    str = "op_home_enter";
                }
                if (str != null) {
                    com.baidu.tieba.util.ak.a(str, this.d, 0L);
                }
            }
            this.d = -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        com.baidu.tieba.util.am.a((Activity) this);
    }
}
