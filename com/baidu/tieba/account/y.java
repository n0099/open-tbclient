package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements TextWatcher {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.a.i();
        str = this.a.f;
        if (com.baidu.tieba.c.ad.e(str)) {
            return;
        }
        String editable2 = editable.toString();
        str2 = this.a.f;
        if (editable2.equals(str2)) {
            this.a.o();
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.a.m;
        if (z) {
            this.a.p();
        }
        this.a.n = true;
        this.a.s();
        this.a.t();
    }
}
