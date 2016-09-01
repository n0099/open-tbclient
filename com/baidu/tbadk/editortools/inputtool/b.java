package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView avR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.avR = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.avR.avN;
        if (textWatcher != null) {
            textWatcher2 = this.avR.avN;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        Pattern pattern;
        SpannableStringBuilder fx;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.avR.avN;
        if (textWatcher != null) {
            textWatcher2 = this.avR.avN;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.avR.avP;
        if (z) {
            pattern = InputView.avL;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fx = this.avR.fx(charSequence.toString());
            this.avR.avP = false;
            this.avR.avQ = i + i3;
            this.avR.setText(fx);
            return;
        }
        this.avR.avP = true;
        i4 = this.avR.avQ;
        if (i4 != -1) {
            InputView inputView = this.avR;
            i5 = this.avR.avQ;
            inputView.setSelection(i5);
            this.avR.avQ = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.avR.avN;
        if (textWatcher != null) {
            textWatcher2 = this.avR.avN;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.avR.b(new com.baidu.tbadk.editortools.a(4, -1, this.avR.getText().toString()));
        }
    }
}
