package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
/* loaded from: classes.dex */
final class am implements TextWatcher {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.a.n = true;
        this.a.g();
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        this.a.c();
    }
}
