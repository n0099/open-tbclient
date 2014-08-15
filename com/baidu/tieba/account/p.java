package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class p implements TextWatcher {
    final /* synthetic */ ActivationActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ActivationActivity activationActivity) {
        this.a = activationActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        RelativeLayout relativeLayout;
        int i;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i2;
        int i3;
        RelativeLayout relativeLayout2;
        if (editable.length() == 6) {
            relativeLayout2 = this.a.k;
            relativeLayout2.setEnabled(true);
        } else {
            relativeLayout = this.a.k;
            relativeLayout.setEnabled(false);
        }
        i = this.a.y;
        if (i != 0) {
            this.a.y = 0;
            linearLayout = this.a.d;
            linearLayout.setBackgroundResource(com.baidu.tieba.t.pass_input);
            linearLayout2 = this.a.d;
            i2 = this.a.w;
            i3 = this.a.x;
            linearLayout2.setPadding(i2, 0, i3, 0);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
