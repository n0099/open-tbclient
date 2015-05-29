package com.baidu.tieba.account.login;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements TextWatcher {
    final /* synthetic */ Login2Activity ayM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Login2Activity login2Activity) {
        this.ayM = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.ayM.ayq = true;
        this.ayM.FF();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.ayM.Fw();
    }
}
