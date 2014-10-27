package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class p implements TextWatcher {
    final /* synthetic */ ActivationActivity aeY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.aeY = activationActivity;
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
            relativeLayout2 = this.aeY.aeJ;
            relativeLayout2.setEnabled(true);
        } else {
            relativeLayout = this.aeY.aeJ;
            relativeLayout.setEnabled(false);
        }
        i = this.aeY.aeV;
        if (i != 0) {
            this.aeY.aeV = 0;
            linearLayout = this.aeY.aeD;
            linearLayout.setBackgroundResource(com.baidu.tieba.u.pass_input);
            linearLayout2 = this.aeY.aeD;
            i2 = this.aeY.aeT;
            i3 = this.aeY.aeU;
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
