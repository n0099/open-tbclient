package com.baidu.tieba.account.login;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tbadk.core.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements TextWatcher {
    final /* synthetic */ Login2Activity axg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Login2Activity login2Activity) {
        this.axg = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.axg.awJ;
        if (z) {
            this.axg.EK();
        }
        this.axg.awK = true;
        this.axg.EN();
        this.axg.EO();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.axg.EE();
        str = this.axg.mAccount;
        if (!bd.isEmpty(str)) {
            String editable2 = editable.toString();
            str2 = this.axg.mAccount;
            if (!editable2.equals(str2)) {
                return;
            }
            this.axg.EJ();
        }
    }
}
