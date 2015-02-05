package com.baidu.tieba.im.searchGroup;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements TextWatcher {
    final /* synthetic */ b bnO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bnO = bVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        ImageButton imageButton;
        ImageButton imageButton2;
        editText = this.bnO.bnJ;
        if (editText.length() > 0) {
            imageButton2 = this.bnO.bnK;
            imageButton2.setVisibility(0);
            return;
        }
        imageButton = this.bnO.bnK;
        imageButton.setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        View view;
        view = this.bnO.bnL;
        view.setTag(editable.toString().trim());
    }
}
