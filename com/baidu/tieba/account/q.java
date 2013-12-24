package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class q implements TextWatcher {
    final /* synthetic */ ActivationActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(ActivationActivity activationActivity) {
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
            relativeLayout2 = this.a.j;
            relativeLayout2.setEnabled(true);
        } else {
            relativeLayout = this.a.j;
            relativeLayout.setEnabled(false);
        }
        i = this.a.y;
        if (i != 0) {
            this.a.y = 0;
            linearLayout = this.a.c;
            linearLayout.setBackgroundResource(R.drawable.pass_input);
            linearLayout2 = this.a.c;
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
