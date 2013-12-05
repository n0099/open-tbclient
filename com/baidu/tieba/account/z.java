package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tieba.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1109a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(LoginActivity loginActivity) {
        this.f1109a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.f1109a.m;
        if (z) {
            this.f1109a.k();
        }
        this.f1109a.n = true;
        this.f1109a.n();
        this.f1109a.o();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.f1109a.d();
        str = this.f1109a.f;
        if (!bb.c(str)) {
            String obj = editable.toString();
            str2 = this.f1109a.f;
            if (obj.equals(str2)) {
                this.f1109a.j();
            }
        }
    }
}
