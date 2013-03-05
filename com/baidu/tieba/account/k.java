package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
class k implements TextWatcher {
    final /* synthetic */ ActivationActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ActivationActivity activationActivity) {
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
            relativeLayout2 = this.a.l;
            relativeLayout2.setEnabled(true);
        } else {
            relativeLayout = this.a.l;
            relativeLayout.setEnabled(false);
        }
        i = this.a.A;
        if (i != 0) {
            this.a.A = 0;
            linearLayout = this.a.e;
            linearLayout.setBackgroundResource(R.drawable.pass_input);
            linearLayout2 = this.a.e;
            i2 = this.a.y;
            i3 = this.a.z;
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
