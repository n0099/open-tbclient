package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class r implements TextWatcher {
    final /* synthetic */ ActivationActivity aSr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(ActivationActivity activationActivity) {
        this.aSr = activationActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        int i;
        if (editable.length() == 6) {
            this.aSr.aSd.setEnabled(true);
        } else {
            this.aSr.aSd.setEnabled(false);
        }
        i = this.aSr.aSo;
        if (i != 0) {
            this.aSr.aSo = 0;
            this.aSr.aRX.setBackgroundResource(t.f.pass_input);
            this.aSr.aRX.setPadding(this.aSr.aSm, 0, this.aSr.aSn, 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
