package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f893a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(LoginActivity loginActivity) {
        this.f893a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.f893a.q;
        if (z) {
            this.f893a.r();
        }
        this.f893a.r = true;
        this.f893a.u();
        this.f893a.v();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.f893a.k();
        str = this.f893a.j;
        if (!com.baidu.tieba.util.ai.c(str)) {
            String editable2 = editable.toString();
            str2 = this.f893a.j;
            if (!editable2.equals(str2)) {
                return;
            }
            this.f893a.q();
        }
    }
}
