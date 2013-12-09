package com.baidu.tieba.im.searchGroup;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f1875a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.f1875a = bVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        ImageButton imageButton;
        ImageButton imageButton2;
        editText = this.f1875a.e;
        if (editText.length() > 0) {
            imageButton2 = this.f1875a.f;
            imageButton2.setVisibility(0);
            return;
        }
        imageButton = this.f1875a.f;
        imageButton.setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        button = this.f1875a.h;
        button.setTag(editable.toString().trim());
    }
}
