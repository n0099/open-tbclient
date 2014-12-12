package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class q implements TextWatcher {
    final /* synthetic */ ActivationActivity amw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
        this.amw = activationActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        RelativeLayout relativeLayout;
        int i;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i2;
        int i3;
        RelativeLayout relativeLayout2;
        if (editable.length() == 6) {
            relativeLayout2 = this.amw.ami;
            relativeLayout2.setEnabled(true);
        } else {
            relativeLayout = this.amw.ami;
            relativeLayout.setEnabled(false);
        }
        i = this.amw.amt;
        if (i != 0) {
            this.amw.amt = 0;
            linearLayout = this.amw.amc;
            linearLayout.setBackgroundResource(com.baidu.tieba.v.pass_input);
            linearLayout2 = this.amw.amc;
            i2 = this.amw.amr;
            i3 = this.amw.ams;
            linearLayout2.setPadding(i2, 0, i3, 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
