package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f912a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(LoginActivity loginActivity) {
        this.f912a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.f912a.q;
        if (z) {
            this.f912a.r();
        }
        this.f912a.r = true;
        this.f912a.u();
        this.f912a.v();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.f912a.k();
        str = this.f912a.j;
        if (!com.baidu.tieba.util.ap.c(str)) {
            String editable2 = editable.toString();
            str2 = this.f912a.j;
            if (!editable2.equals(str2)) {
                return;
            }
            this.f912a.q();
        }
    }
}
