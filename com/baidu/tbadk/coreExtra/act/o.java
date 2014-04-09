package com.baidu.tbadk.coreExtra.act;

import android.app.AlertDialog;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o implements View.OnClickListener {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        EditText editText;
        EditText editText2;
        LoginActivity loginActivity = this.a;
        InputMethodManager inputMethodManager = this.a.b;
        editText = this.a.o;
        loginActivity.HidenSoftKeyPad(inputMethodManager, editText);
        LoginActivity loginActivity2 = this.a;
        InputMethodManager inputMethodManager2 = this.a.b;
        editText2 = this.a.p;
        loginActivity2.HidenSoftKeyPad(inputMethodManager2, editText2);
        boolean z = false;
        String c = UtilHelper.c("ro.miui.ui.version.name");
        if (c != null && "V5".equals(c)) {
            z = true;
        }
        if (z) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a);
            builder.setTitle(com.baidu.tbadk.l.register_tip);
            builder.setPositiveButton(com.baidu.tbadk.l.alert_yes_btn, new p(this));
            builder.setNegativeButton(com.baidu.tbadk.l.alert_no_button, new q(this));
            builder.create().show();
            return;
        }
        LoginActivity.o(this.a);
    }
}
