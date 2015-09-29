package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class m implements TextWatcher {
    final /* synthetic */ ActivationActivity aER;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ActivationActivity activationActivity) {
        this.aER = activationActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i;
        if (editable.length() == 6) {
            this.aER.aEE.setEnabled(true);
        } else {
            this.aER.aEE.setEnabled(false);
        }
        i = this.aER.aEO;
        if (i != 0) {
            this.aER.aEO = 0;
            this.aER.aEy.setBackgroundResource(i.e.pass_input);
            this.aER.aEy.setPadding(this.aER.aEM, 0, this.aER.aEN, 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
