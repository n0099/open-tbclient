package com.baidu.tieba.im.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v implements TextWatcher {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(h hVar) {
        this.a = hVar;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        Button button;
        boolean X;
        Button button2;
        Button button3;
        if (editable == null || editable.length() <= 0) {
            button = this.a.F;
            button.setEnabled(false);
            return;
        }
        X = this.a.X();
        if (X) {
            button3 = this.a.F;
            button3.setEnabled(true);
            return;
        }
        button2 = this.a.F;
        button2.setEnabled(false);
    }
}
