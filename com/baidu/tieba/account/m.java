package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class m implements TextWatcher {
    final /* synthetic */ ActivationActivity aDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ActivationActivity activationActivity) {
        this.aDW = activationActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i;
        if (editable.length() == 6) {
            this.aDW.aDJ.setEnabled(true);
        } else {
            this.aDW.aDJ.setEnabled(false);
        }
        i = this.aDW.aDT;
        if (i != 0) {
            this.aDW.aDT = 0;
            this.aDW.aDD.setBackgroundResource(i.e.pass_input);
            this.aDW.aDD.setPadding(this.aDW.aDR, 0, this.aDW.aDS, 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
