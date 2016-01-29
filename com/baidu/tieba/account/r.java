package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class r implements TextWatcher {
    final /* synthetic */ ActivationActivity aJA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ActivationActivity activationActivity) {
        this.aJA = activationActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i;
        if (editable.length() == 6) {
            this.aJA.aJm.setEnabled(true);
        } else {
            this.aJA.aJm.setEnabled(false);
        }
        i = this.aJA.aJx;
        if (i != 0) {
            this.aJA.aJx = 0;
            this.aJA.aJg.setBackgroundResource(t.f.pass_input);
            this.aJA.aJg.setPadding(this.aJA.aJv, 0, this.aJA.aJw, 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
