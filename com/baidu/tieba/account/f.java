package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
class f implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ActivationActivity f666a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(ActivationActivity activationActivity) {
        this.f666a = activationActivity;
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
            relativeLayout2 = this.f666a.l;
            relativeLayout2.setEnabled(true);
        } else {
            relativeLayout = this.f666a.l;
            relativeLayout.setEnabled(false);
        }
        i = this.f666a.A;
        if (i != 0) {
            this.f666a.A = 0;
            linearLayout = this.f666a.c;
            linearLayout.setBackgroundResource(R.drawable.pass_input);
            linearLayout2 = this.f666a.c;
            i2 = this.f666a.y;
            i3 = this.f666a.z;
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
