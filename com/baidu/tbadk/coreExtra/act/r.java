package com.baidu.tbadk.coreExtra.act;

import android.text.Editable;
import android.text.TextWatcher;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
final class r implements TextWatcher {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z;
        z = this.a.m;
        if (z) {
            this.a.f();
        }
        this.a.n = true;
        this.a.g();
        this.a.h();
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        String str;
        String str2;
        this.a.c();
        str = this.a.f;
        if (!bc.c(str)) {
            String editable2 = editable.toString();
            str2 = this.a.f;
            if (editable2.equals(str2)) {
                LoginActivity.h(this.a);
            }
        }
    }
}
