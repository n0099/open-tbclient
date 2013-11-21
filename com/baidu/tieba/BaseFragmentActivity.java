package com.baidu.tieba;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.bg;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public abstract class BaseFragmentActivity extends android.support.v4.app.n {

    /* renamed from: a  reason: collision with root package name */
    protected ProgressDialog f997a = null;
    private DialogInterface.OnCancelListener b = null;
    private AlertDialog c = null;
    private int d = -1;
    private e e;

    protected abstract void a(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.account.a.a().c();
        TiebaApplication.u(true);
        TiebaApplication.g().a(getClass().getName());
        this.e = new e();
        if (TiebaApplication.g().s()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.h.a());
            } catch (Exception e) {
                bg.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.g().ap() != this.d) {
            this.d = TiebaApplication.g().ap();
            a(this.d);
        }
        if (TiebaApplication.g().s()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                bg.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TiebaApplication.g().aA();
        TiebaApplication.g().a(getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onPause() {
        super.onPause();
        TiebaApplication.g().aB();
        if (TiebaApplication.g().s()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                bg.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onDestroy() {
        if (this.e != null) {
            this.e.a();
        }
        super.onDestroy();
    }

    public e a() {
        return this.e;
    }

    public void a(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.f997a = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.f997a = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, true, onCancelListener);
        }
    }

    public void b() {
        if (this.f997a != null) {
            try {
                if (this.f997a.isShowing()) {
                    this.f997a.dismiss();
                }
            } catch (Exception e) {
                bg.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.f997a = null;
        }
    }

    public void a(String str) {
        UtilHelper.a((Context) this, str);
    }

    public void b(int i) {
        UtilHelper.a((Context) this, i);
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
