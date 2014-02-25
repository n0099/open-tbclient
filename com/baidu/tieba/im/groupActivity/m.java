package com.baidu.tieba.im.groupActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements TextWatcher {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(e eVar) {
        this.a = eVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        ImageButton imageButton;
        ImageButton imageButton2;
        editText = this.a.i;
        if (editText.getText().length() > 0) {
            imageButton2 = this.a.j;
            imageButton2.setVisibility(0);
            return;
        }
        imageButton = this.a.j;
        imageButton.setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
