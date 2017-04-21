package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView aAD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.aAD = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.aAD.aAz;
        if (textWatcher != null) {
            textWatcher2 = this.aAD.aAz;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        Pattern pattern;
        SpannableStringBuilder fq;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.aAD.aAz;
        if (textWatcher != null) {
            textWatcher2 = this.aAD.aAz;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.aAD.aAB;
        if (z) {
            pattern = InputView.aAx;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fq = this.aAD.fq(charSequence.toString());
            this.aAD.aAB = false;
            this.aAD.aAC = i + i3;
            this.aAD.setText(fq);
            return;
        }
        this.aAD.aAB = true;
        i4 = this.aAD.aAC;
        if (i4 != -1) {
            InputView inputView = this.aAD;
            i5 = this.aAD.aAC;
            inputView.setSelection(i5);
            this.aAD.aAC = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.aAD.aAz;
        if (textWatcher != null) {
            textWatcher2 = this.aAD.aAz;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.aAD.b(new com.baidu.tbadk.editortools.a(4, -1, this.aAD.getText().toString()));
        }
    }
}
