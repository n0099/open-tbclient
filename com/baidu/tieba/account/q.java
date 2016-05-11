package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class q implements TextWatcher {
    final /* synthetic */ ActivationActivity aIG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
        this.aIG = activationActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i;
        if (editable.length() == 6) {
            this.aIG.aIs.setEnabled(true);
        } else {
            this.aIG.aIs.setEnabled(false);
        }
        i = this.aIG.aID;
        if (i != 0) {
            this.aIG.aID = 0;
            this.aIG.aIm.setBackgroundResource(t.f.pass_input);
            this.aIG.aIm.setPadding(this.aIG.aIB, 0, this.aIG.aIC, 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
