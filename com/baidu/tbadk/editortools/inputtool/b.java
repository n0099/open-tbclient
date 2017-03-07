package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView aAl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.aAl = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.aAl.aAh;
        if (textWatcher != null) {
            textWatcher2 = this.aAl.aAh;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        Pattern pattern;
        SpannableStringBuilder fk;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.aAl.aAh;
        if (textWatcher != null) {
            textWatcher2 = this.aAl.aAh;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.aAl.aAj;
        if (z) {
            pattern = InputView.aAf;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fk = this.aAl.fk(charSequence.toString());
            this.aAl.aAj = false;
            this.aAl.aAk = i + i3;
            this.aAl.setText(fk);
            return;
        }
        this.aAl.aAj = true;
        i4 = this.aAl.aAk;
        if (i4 != -1) {
            InputView inputView = this.aAl;
            i5 = this.aAl.aAk;
            inputView.setSelection(i5);
            this.aAl.aAk = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.aAl.aAh;
        if (textWatcher != null) {
            textWatcher2 = this.aAl.aAh;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.aAl.b(new com.baidu.tbadk.editortools.a(4, -1, this.aAl.getText().toString()));
        }
    }
}
