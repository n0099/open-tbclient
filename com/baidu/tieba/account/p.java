package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class p implements TextWatcher {
    final /* synthetic */ ActivationActivity aGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.aGV = activationActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i;
        if (editable.length() == 6) {
            this.aGV.aGI.setEnabled(true);
        } else {
            this.aGV.aGI.setEnabled(false);
        }
        i = this.aGV.aGS;
        if (i != 0) {
            this.aGV.aGS = 0;
            this.aGV.aGC.setBackgroundResource(n.e.pass_input);
            this.aGV.aGC.setPadding(this.aGV.aGQ, 0, this.aGV.aGR, 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
