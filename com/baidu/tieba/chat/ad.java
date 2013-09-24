package com.baidu.tieba.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ac f955a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.f955a = acVar;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        Button button2;
        if (editable == null || editable.toString().trim().length() <= 0) {
            button = this.f955a.d;
            button.setEnabled(false);
            return;
        }
        button2 = this.f955a.d;
        button2.setEnabled(true);
    }
}
