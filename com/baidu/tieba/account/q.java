package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class q implements TextWatcher {
    final /* synthetic */ ActivationActivity aIw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
        this.aIw = activationActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i;
        if (editable.length() == 6) {
            this.aIw.aIj.setEnabled(true);
        } else {
            this.aIw.aIj.setEnabled(false);
        }
        i = this.aIw.aIt;
        if (i != 0) {
            this.aIw.aIt = 0;
            this.aIw.aId.setBackgroundResource(n.f.pass_input);
            this.aIw.aId.setPadding(this.aIw.aIr, 0, this.aIw.aIs, 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
