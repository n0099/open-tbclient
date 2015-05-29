package com.baidu.tieba.account.login;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tbadk.core.util.bb;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements TextWatcher {
    final /* synthetic */ Login2Activity ayM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Login2Activity login2Activity) {
        this.ayM = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.ayM.ayp;
        if (z) {
            this.ayM.FC();
        }
        this.ayM.ayq = true;
        this.ayM.FF();
        this.ayM.FG();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.ayM.Fw();
        str = this.ayM.mAccount;
        if (!bb.isEmpty(str)) {
            String editable2 = editable.toString();
            str2 = this.ayM.mAccount;
            if (!editable2.equals(str2)) {
                return;
            }
            this.ayM.FB();
        }
    }
}
