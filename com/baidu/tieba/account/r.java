package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class r implements TextWatcher {
    final /* synthetic */ ActivationActivity aEn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ActivationActivity activationActivity) {
        this.aEn = activationActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i;
        if (editable.length() == 6) {
            this.aEn.aEa.setEnabled(true);
        } else {
            this.aEn.aEa.setEnabled(false);
        }
        i = this.aEn.aEk;
        if (i != 0) {
            this.aEn.aEk = 0;
            this.aEn.aDU.setBackgroundResource(i.e.pass_input);
            this.aEn.aDU.setPadding(this.aEn.aEi, 0, this.aEn.aEj, 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
