package com.baidu.tieba.im.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cg implements TextWatcher {
    final /* synthetic */ bs a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(bs bsVar) {
        this.a = bsVar;
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
            button = this.a.y;
            button.setEnabled(false);
            return;
        }
        W = this.a.W();
        if (W) {
            button3 = this.a.y;
            button3.setEnabled(true);
            return;
        }
        button2 = this.a.y;
        button2.setEnabled(false);
    }
}
