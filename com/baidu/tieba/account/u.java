package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f891a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(LoginActivity loginActivity) {
        this.f891a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.f891a.q;
        if (z) {
            this.f891a.r();
        }
        this.f891a.r = true;
        this.f891a.u();
        this.f891a.v();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.f891a.k();
        str = this.f891a.j;
        if (!com.baidu.tieba.util.ai.c(str)) {
            String editable2 = editable.toString();
            str2 = this.f891a.j;
            if (!editable2.equals(str2)) {
                return;
            }
            this.f891a.q();
        }
    }
}
