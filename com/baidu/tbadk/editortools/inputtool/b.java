package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.TextWatcher;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView aBq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.aBq = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.aBq.aBm;
        if (textWatcher != null) {
            textWatcher2 = this.aBq.aBm;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.aBq.aBm;
        if (textWatcher != null) {
            textWatcher2 = this.aBq.aBm;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.aBq.aBo;
        if (!z) {
            this.aBq.aBo = true;
            i4 = this.aBq.aBp;
            if (i4 != -1) {
                InputView inputView = this.aBq;
                i5 = this.aBq.aBp;
                inputView.setSelection(i5);
                this.aBq.aBp = -1;
            }
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.aBq.aBm;
        if (textWatcher != null) {
            textWatcher2 = this.aBq.aBm;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.aBq.b(new com.baidu.tbadk.editortools.a(4, -1, this.aBq.getText().toString()));
        }
    }
}
