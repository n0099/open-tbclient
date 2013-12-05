package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1038a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(LoginActivity loginActivity) {
        this.f1038a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f1038a.n = true;
        this.f1038a.n();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.f1038a.d();
    }
}
