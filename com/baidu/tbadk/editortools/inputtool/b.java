package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView ati;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.ati = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.ati.atg;
        if (textWatcher != null) {
            textWatcher2 = this.ati.atg;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.ati.atg;
        if (textWatcher != null) {
            textWatcher2 = this.ati.atg;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.ati.atg;
        if (textWatcher != null) {
            textWatcher2 = this.ati.atg;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.ati.b(new com.baidu.tbadk.editortools.a(4, -1, this.ati.getText().toString()));
        }
    }
}
