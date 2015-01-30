package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class r implements TextWatcher {
    final /* synthetic */ ActivationActivity anq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ActivationActivity activationActivity) {
        this.anq = activationActivity;
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
            relativeLayout2 = this.anq.anc;
            relativeLayout2.setEnabled(true);
        } else {
            relativeLayout = this.anq.anc;
            relativeLayout.setEnabled(false);
        }
        i = this.anq.ann;
        if (i != 0) {
            this.anq.ann = 0;
            linearLayout = this.anq.amW;
            linearLayout.setBackgroundResource(com.baidu.tieba.v.pass_input);
            linearLayout2 = this.anq.amW;
            i2 = this.anq.anl;
            i3 = this.anq.anm;
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
