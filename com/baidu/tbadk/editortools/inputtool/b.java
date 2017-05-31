package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView aAn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.aAn = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.aAn.aAj;
        if (textWatcher != null) {
            textWatcher2 = this.aAn.aAj;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        Pattern pattern;
        SpannableStringBuilder fl;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.aAn.aAj;
        if (textWatcher != null) {
            textWatcher2 = this.aAn.aAj;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.aAn.aAl;
        if (z) {
            pattern = InputView.aAh;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fl = this.aAn.fl(charSequence.toString());
            this.aAn.aAl = false;
            this.aAn.aAm = i + i3;
            this.aAn.setText(fl);
            return;
        }
        this.aAn.aAl = true;
        i4 = this.aAn.aAm;
        if (i4 != -1) {
            InputView inputView = this.aAn;
            i5 = this.aAn.aAm;
            inputView.setSelection(i5);
            this.aAn.aAm = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.aAn.aAj;
        if (textWatcher != null) {
            textWatcher2 = this.aAn.aAj;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.aAn.b(new com.baidu.tbadk.editortools.a(4, -1, this.aAn.getText().toString()));
        }
    }
}
