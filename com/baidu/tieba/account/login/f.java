package com.baidu.tieba.account.login;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tbadk.core.util.aq;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements TextWatcher {
    final /* synthetic */ Login2Activity aGf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(Login2Activity login2Activity) {
        this.aGf = login2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.aGf.aFH;
        if (z) {
            this.aGf.Gp();
        }
        this.aGf.aFI = true;
        this.aGf.Gs();
        this.aGf.Gt();
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.aGf.Gl();
        str = this.aGf.mAccount;
        if (!aq.isEmpty(str)) {
            String editable2 = editable.toString();
            str2 = this.aGf.mAccount;
            if (!editable2.equals(str2)) {
                return;
            }
            this.aGf.y(0, "");
        }
    }
}
