package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView arF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.arF = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.arF.arD;
        if (textWatcher != null) {
            textWatcher2 = this.arF.arD;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.arF.arD;
        if (textWatcher != null) {
            textWatcher2 = this.arF.arD;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.arF.arD;
        if (textWatcher != null) {
            textWatcher2 = this.arF.arD;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.arF.b(new com.baidu.tbadk.editortools.a(4, -1, this.arF.getText().toString()));
        }
    }
}
