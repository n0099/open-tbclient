package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView arf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.arf = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.arf.arb;
        if (textWatcher != null) {
            textWatcher2 = this.arf.arb;
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
        textWatcher = this.arf.arb;
        if (textWatcher != null) {
            textWatcher2 = this.arf.arb;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.arf.ard;
        if (z) {
            pattern = InputView.aqZ;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fq = this.arf.fq(charSequence.toString());
            this.arf.ard = false;
            this.arf.are = i + i3;
            this.arf.setText(fq);
            return;
        }
        this.arf.ard = true;
        i4 = this.arf.are;
        if (i4 != -1) {
            InputView inputView = this.arf;
            i5 = this.arf.are;
            inputView.setSelection(i5);
            this.arf.are = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.arf.arb;
        if (textWatcher != null) {
            textWatcher2 = this.arf.arb;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.arf.b(new com.baidu.tbadk.editortools.a(4, -1, this.arf.getText().toString()));
        }
    }
}
