package com.baidu.tieba.im.chat;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bt implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bg f1531a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bt(bg bgVar) {
        this.f1531a = bgVar;
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
            button = this.f1531a.y;
            button.setEnabled(false);
            return;
        }
        U = this.f1531a.U();
        if (U) {
            button3 = this.f1531a.y;
            button3.setEnabled(true);
            return;
        }
        button2 = this.f1531a.y;
        button2.setEnabled(false);
    }
}
