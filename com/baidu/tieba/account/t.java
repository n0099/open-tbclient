package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements TextWatcher {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.a.q;
        if (z) {
            this.a.t();
        }
        this.a.r = true;
        this.a.w();
        this.a.x();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.a.m();
        str = this.a.j;
        if (!com.baidu.tieba.d.ad.c(str)) {
            String editable2 = editable.toString();
            str2 = this.a.j;
            if (!editable2.equals(str2)) {
                return;
            }
            this.a.s();
        }
    }
}
