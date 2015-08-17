package com.baidu.tieba.account.login;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements TextWatcher {
    final /* synthetic */ Login2Activity aGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Login2Activity login2Activity) {
        this.aGf = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.aGf.aFI = true;
        this.aGf.Gs();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.aGf.Gl();
    }
}
