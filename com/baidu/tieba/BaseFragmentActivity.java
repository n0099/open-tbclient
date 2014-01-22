package com.baidu.tieba;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.mobstat.StatService;
import com.baidu.tieba.util.bz;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public abstract class BaseFragmentActivity extends android.support.v4.app.n {
    protected ProgressDialog a = null;
    private DialogInterface.OnCancelListener b = null;
    private int c = -1;
    private e d;

    protected abstract void a(int i);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.baidu.tieba.account.l.a().b();
        TiebaApplication.v(true);
        bz.a(getClass().getName());
        this.d = new e();
        if (TiebaApplication.h().s()) {
            try {
                StatService.setAppChannel(com.baidu.tieba.data.h.a());
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(getClass().getName(), "onCreate", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onResume() {
        super.onResume();
        if (TiebaApplication.h().al() != this.c) {
            this.c = TiebaApplication.h().al();
            a(this.c);
        }
        if (TiebaApplication.h().s()) {
            try {
                StatService.onResume(this);
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(getClass().getName(), "onResume", e.getMessage());
            }
        }
        TiebaApplication.h().ay();
        bz.a(getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onPause() {
        super.onPause();
        TiebaApplication.h().az();
        if (TiebaApplication.h().s()) {
            try {
                StatService.onPause(this);
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(getClass().getName(), "onPause", e.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.n, android.app.Activity
    public void onDestroy() {
        if (this.d != null) {
            this.d.b();
        }
        super.onDestroy();
    }

    public e a() {
        return this.d;
    }

    public void a(String str, DialogInterface.OnCancelListener onCancelListener) {
        if (str != null) {
            this.a = ProgressDialog.show(this, "", str, true, true, onCancelListener);
        } else {
            this.a = ProgressDialog.show(this, "", getResources().getString(R.string.Waiting), true, true, onCancelListener);
        }
    }

    public void b() {
        if (this.a != null) {
            try {
                if (this.a.isShowing()) {
                    this.a.dismiss();
                }
            } catch (Exception e) {
                com.baidu.adp.lib.g.e.b(getClass().getName(), "closeLoadingDialog", e.getMessage());
            }
            this.a = null;
        }
    }

    public void a(String str) {
        com.baidu.adp.lib.g.g.a((Context) this, str);
    }

    public void b(int i) {
        com.baidu.adp.lib.g.g.a((Context) this, i);
    }

    @Override // android.support.v4.app.n, android.app.Activity, android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        if (this.d == null) {
            this.d = new e();
        }
        this.d.a(str, context, attributeSet);
        return super.onCreateView(str, context, attributeSet);
    }

    @Override // android.support.v4.app.n, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82 && keyEvent.isLongPress()) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
