package com.baidu.tieba.account.login;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tbadk.core.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements TextWatcher {
    final /* synthetic */ Login2Activity awY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Login2Activity login2Activity) {
        this.awY = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.awY.awB;
        if (z) {
            this.awY.EE();
        }
        this.awY.awC = true;
        this.awY.EH();
        this.awY.EI();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.awY.Ey();
        str = this.awY.mAccount;
        if (!bd.isEmpty(str)) {
            String editable2 = editable.toString();
            str2 = this.awY.mAccount;
            if (!editable2.equals(str2)) {
                return;
            }
            this.awY.ED();
        }
    }
}
