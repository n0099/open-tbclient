package com.baidu.tieba.im.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bz implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bm f1584a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bm bmVar) {
        this.f1584a = bmVar;
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
        boolean S;
        Button button2;
        Button button3;
        if (editable == null || editable.length() <= 0) {
            button = this.f1584a.y;
            button.setEnabled(false);
            return;
        }
        S = this.f1584a.S();
        if (S) {
            button3 = this.f1584a.y;
            button3.setEnabled(true);
            return;
        }
        button2 = this.f1584a.y;
        button2.setEnabled(false);
    }
}
