package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class x implements TextWatcher {
    final /* synthetic */ ActivationActivity awV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(ActivationActivity activationActivity) {
        this.awV = activationActivity;
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
            relativeLayout2 = this.awV.awI;
            relativeLayout2.setEnabled(true);
        } else {
            relativeLayout = this.awV.awI;
            relativeLayout.setEnabled(false);
        }
        i = this.awV.awS;
        if (i != 0) {
            this.awV.awS = 0;
            linearLayout = this.awV.awC;
            linearLayout.setBackgroundResource(com.baidu.tieba.p.pass_input);
            linearLayout2 = this.awV.awC;
            i2 = this.awV.awQ;
            i3 = this.awV.awR;
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
