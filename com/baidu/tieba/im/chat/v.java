package com.baidu.tieba.im.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements TextWatcher {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(h hVar) {
        this.a = hVar;
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
        boolean W;
        Button button2;
        Button button3;
        if (editable == null || editable.length() <= 0) {
            button = this.a.E;
            button.setEnabled(false);
            return;
        }
        W = this.a.W();
        if (W) {
            button3 = this.a.E;
            button3.setEnabled(true);
            return;
        }
        button2 = this.a.E;
        button2.setEnabled(false);
    }
}
