package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tieba.util.be;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1094a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(LoginActivity loginActivity) {
        this.f1094a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.f1094a.m;
        if (z) {
            this.f1094a.k();
        }
        this.f1094a.n = true;
        this.f1094a.n();
        this.f1094a.o();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.f1094a.d();
        str = this.f1094a.f;
        if (!be.c(str)) {
            String obj = editable.toString();
            str2 = this.f1094a.f;
            if (obj.equals(str2)) {
                this.f1094a.j();
            }
        }
    }
}
