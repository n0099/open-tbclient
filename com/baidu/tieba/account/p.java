package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class p implements TextWatcher {
    final /* synthetic */ ActivationActivity afg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.afg = activationActivity;
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
            relativeLayout2 = this.afg.aeR;
            relativeLayout2.setEnabled(true);
        } else {
            relativeLayout = this.afg.aeR;
            relativeLayout.setEnabled(false);
        }
        i = this.afg.afd;
        if (i != 0) {
            this.afg.afd = 0;
            linearLayout = this.afg.aeL;
            linearLayout.setBackgroundResource(com.baidu.tieba.u.pass_input);
            linearLayout2 = this.afg.aeL;
            i2 = this.afg.afb;
            i3 = this.afg.afc;
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
