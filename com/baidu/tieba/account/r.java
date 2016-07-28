package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class r implements TextWatcher {
    final /* synthetic */ ActivationActivity aMX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ActivationActivity activationActivity) {
        this.aMX = activationActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i;
        if (editable.length() == 6) {
            this.aMX.aMJ.setEnabled(true);
        } else {
            this.aMX.aMJ.setEnabled(false);
        }
        i = this.aMX.aMU;
        if (i != 0) {
            this.aMX.aMU = 0;
            this.aMX.aMD.setBackgroundResource(u.f.pass_input);
            this.aMX.aMD.setPadding(this.aMX.aMS, 0, this.aMX.aMT, 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
