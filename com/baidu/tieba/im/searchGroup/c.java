package com.baidu.tieba.im.searchGroup;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements TextWatcher {
    final /* synthetic */ b bhQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bhQ = bVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        ImageButton imageButton;
        ImageButton imageButton2;
        editText = this.bhQ.bhM;
        if (editText.length() > 0) {
            imageButton2 = this.bhQ.bhN;
            imageButton2.setVisibility(0);
            return;
        }
        imageButton = this.bhQ.bhN;
        imageButton.setVisibility(8);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        Button button;
        button = this.bhQ.bhO;
        button.setTag(editable.toString().trim());
    }
}
