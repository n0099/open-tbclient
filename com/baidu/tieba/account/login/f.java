package com.baidu.tieba.account.login;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements TextWatcher {
    final /* synthetic */ Login2Activity ayN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Login2Activity login2Activity) {
        this.ayN = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.ayN.ayq;
        if (z) {
            this.ayN.FD();
        }
        this.ayN.ayr = true;
        this.ayN.FG();
        this.ayN.FH();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.ayN.Fx();
        str = this.ayN.mAccount;
        if (!bb.isEmpty(str)) {
            String editable2 = editable.toString();
            str2 = this.ayN.mAccount;
            if (!editable2.equals(str2)) {
                return;
            }
            this.ayN.FC();
        }
    }
}
