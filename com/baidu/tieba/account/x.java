package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class x implements TextWatcher {
    final /* synthetic */ ActivationActivity avu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(ActivationActivity activationActivity) {
        this.avu = activationActivity;
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
            relativeLayout2 = this.avu.avg;
            relativeLayout2.setEnabled(true);
        } else {
            relativeLayout = this.avu.avg;
            relativeLayout.setEnabled(false);
        }
        i = this.avu.avr;
        if (i != 0) {
            this.avu.avr = 0;
            linearLayout = this.avu.ava;
            linearLayout.setBackgroundResource(com.baidu.tieba.u.pass_input);
            linearLayout2 = this.avu.ava;
            i2 = this.avu.avp;
            i3 = this.avu.avq;
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
