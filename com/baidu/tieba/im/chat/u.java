package com.baidu.tieba.im.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements TextWatcher {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(g gVar) {
        this.a = gVar;
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
        boolean Y;
        Button button2;
        Button button3;
        if (editable == null || editable.length() <= 0) {
            button = this.a.E;
            button.setEnabled(false);
            return;
        }
        Y = this.a.Y();
        if (Y) {
            button3 = this.a.E;
            button3.setEnabled(true);
            return;
        }
        button2 = this.a.E;
        button2.setEnabled(false);
    }
}
