package com.baidu.tieba.im.searchGroup;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ g f1882a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.f1882a = gVar;
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
        Button button2;
        Button button3;
        if (editable.toString().trim().length() == 0) {
            button3 = this.f1882a.f;
            button3.setVisibility(8);
        } else {
            button = this.f1882a.f;
            button.setVisibility(0);
        }
        button2 = this.f1882a.g;
        button2.setTag(editable.toString().trim());
    }
}
