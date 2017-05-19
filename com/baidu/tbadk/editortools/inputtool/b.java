package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView aAB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.aAB = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.aAB.aAx;
        if (textWatcher != null) {
            textWatcher2 = this.aAB.aAx;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        Pattern pattern;
        SpannableStringBuilder fn;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.aAB.aAx;
        if (textWatcher != null) {
            textWatcher2 = this.aAB.aAx;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.aAB.aAz;
        if (z) {
            pattern = InputView.aAv;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fn = this.aAB.fn(charSequence.toString());
            this.aAB.aAz = false;
            this.aAB.aAA = i + i3;
            this.aAB.setText(fn);
            return;
        }
        this.aAB.aAz = true;
        i4 = this.aAB.aAA;
        if (i4 != -1) {
            InputView inputView = this.aAB;
            i5 = this.aAB.aAA;
            inputView.setSelection(i5);
            this.aAB.aAA = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.aAB.aAx;
        if (textWatcher != null) {
            textWatcher2 = this.aAB.aAx;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.aAB.b(new com.baidu.tbadk.editortools.a(4, -1, this.aAB.getText().toString()));
        }
    }
}
