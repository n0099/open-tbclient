package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView auG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.auG = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.auG.auC;
        if (textWatcher != null) {
            textWatcher2 = this.auG.auC;
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
        textWatcher = this.auG.auC;
        if (textWatcher != null) {
            textWatcher2 = this.auG.auC;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.auG.auE;
        if (z) {
            pattern = InputView.auA;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fl = this.auG.fl(charSequence.toString());
            this.auG.auE = false;
            this.auG.auF = i + i3;
            this.auG.setText(fl);
            return;
        }
        this.auG.auE = true;
        i4 = this.auG.auF;
        if (i4 != -1) {
            InputView inputView = this.auG;
            i5 = this.auG.auF;
            inputView.setSelection(i5);
            this.auG.auF = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.auG.auC;
        if (textWatcher != null) {
            textWatcher2 = this.auG.auC;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.auG.b(new com.baidu.tbadk.editortools.a(4, -1, this.auG.getText().toString()));
        }
    }
}
