package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements TextWatcher {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.a.m;
        if (z) {
            this.a.k();
        }
        this.a.n = true;
        this.a.n();
        this.a.o();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.a.d();
        str = this.a.f;
        if (!com.baidu.tieba.util.bs.c(str)) {
            String editable2 = editable.toString();
            str2 = this.a.f;
            if (!editable2.equals(str2)) {
                return;
            }
            this.a.j();
        }
    }
}
