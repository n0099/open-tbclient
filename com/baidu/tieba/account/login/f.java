package com.baidu.tieba.account.login;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements TextWatcher {
    final /* synthetic */ Login2Activity awY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Login2Activity login2Activity) {
        this.awY = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.awY.awC = true;
        this.awY.EH();
        this.awY.EI();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.awY.Ey();
    }
}
