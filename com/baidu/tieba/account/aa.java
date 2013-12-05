package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1037a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(LoginActivity loginActivity) {
        this.f1037a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f1037a.n = true;
        this.f1037a.n();
        this.f1037a.o();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f1037a.d();
    }
}
