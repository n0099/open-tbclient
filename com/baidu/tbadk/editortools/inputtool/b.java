package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView atO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.atO = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.atO.atK;
        if (textWatcher != null) {
            textWatcher2 = this.atO.atK;
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
        textWatcher = this.atO.atK;
        if (textWatcher != null) {
            textWatcher2 = this.atO.atK;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.atO.atM;
        if (z) {
            pattern = InputView.atI;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fn = this.atO.fn(charSequence.toString());
            this.atO.atM = false;
            this.atO.atN = i + i3;
            this.atO.setText(fn);
            return;
        }
        this.atO.atM = true;
        i4 = this.atO.atN;
        if (i4 != -1) {
            InputView inputView = this.atO;
            i5 = this.atO.atN;
            inputView.setSelection(i5);
            this.atO.atN = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.atO.atK;
        if (textWatcher != null) {
            textWatcher2 = this.atO.atK;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.atO.b(new com.baidu.tbadk.editortools.a(4, -1, this.atO.getText().toString()));
        }
    }
}
