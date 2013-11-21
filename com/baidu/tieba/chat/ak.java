package com.baidu.tieba.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ai f1133a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ai aiVar) {
        this.f1133a = aiVar;
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
            button = this.f1133a.d;
            button.setEnabled(false);
            return;
        }
        button2 = this.f1133a.d;
        button2.setEnabled(true);
    }
}
