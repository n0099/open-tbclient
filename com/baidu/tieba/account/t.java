package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f679a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(LoginActivity loginActivity) {
        this.f679a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.f679a.q;
        if (z) {
            this.f679a.t();
        }
        this.f679a.r = true;
        this.f679a.w();
        this.f679a.x();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.f679a.m();
        str = this.f679a.j;
        if (!com.baidu.tieba.util.y.c(str)) {
            String editable2 = editable.toString();
            str2 = this.f679a.j;
            if (!editable2.equals(str2)) {
                return;
            }
            this.f679a.s();
        }
    }
}
