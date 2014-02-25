package com.baidu.tieba.im.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements TextWatcher {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(a aVar) {
        this.a = aVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        boolean ab;
        Button button2;
        Button button3;
        if (editable == null || editable.length() <= 0) {
            button = this.a.F;
            button.setEnabled(false);
            return;
        }
        ab = this.a.ab();
        if (ab) {
            button3 = this.a.F;
            button3.setEnabled(true);
            return;
        }
        button2 = this.a.F;
        button2.setEnabled(false);
    }
}
