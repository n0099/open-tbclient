package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class m implements TextWatcher {
    final /* synthetic */ ActivationActivity aFc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ActivationActivity activationActivity) {
        this.aFc = activationActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i;
        if (editable.length() == 6) {
            this.aFc.aEP.setEnabled(true);
        } else {
            this.aFc.aEP.setEnabled(false);
        }
        i = this.aFc.aEZ;
        if (i != 0) {
            this.aFc.aEZ = 0;
            this.aFc.aEJ.setBackgroundResource(i.e.pass_input);
            this.aFc.aEJ.setPadding(this.aFc.aEX, 0, this.aFc.aEY, 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
