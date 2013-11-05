package com.baidu.tieba.im.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bh f1448a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(bh bhVar) {
        this.f1448a = bhVar;
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
        boolean U;
        Button button2;
        Button button3;
        if (editable == null || editable.length() <= 0) {
            button = this.f1448a.x;
            button.setEnabled(false);
            return;
        }
        U = this.f1448a.U();
        if (U) {
            button3 = this.f1448a.x;
            button3.setEnabled(true);
            return;
        }
        button2 = this.f1448a.x;
        button2.setEnabled(false);
    }
}
