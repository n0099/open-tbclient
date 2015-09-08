package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class r implements TextWatcher {
    final /* synthetic */ ActivationActivity aFV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ActivationActivity activationActivity) {
        this.aFV = activationActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i;
        if (editable.length() == 6) {
            this.aFV.aFI.setEnabled(true);
        } else {
            this.aFV.aFI.setEnabled(false);
        }
        i = this.aFV.aFS;
        if (i != 0) {
            this.aFV.aFS = 0;
            this.aFV.aFC.setBackgroundResource(i.e.pass_input);
            this.aFV.aFC.setPadding(this.aFV.aFQ, 0, this.aFV.aFR, 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
