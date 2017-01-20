package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView auQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.auQ = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.auQ.auM;
        if (textWatcher != null) {
            textWatcher2 = this.auQ.auM;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        Pattern pattern;
        SpannableStringBuilder fv;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.auQ.auM;
        if (textWatcher != null) {
            textWatcher2 = this.auQ.auM;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.auQ.auO;
        if (z) {
            pattern = InputView.auK;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fv = this.auQ.fv(charSequence.toString());
            this.auQ.auO = false;
            this.auQ.auP = i + i3;
            this.auQ.setText(fv);
            return;
        }
        this.auQ.auO = true;
        i4 = this.auQ.auP;
        if (i4 != -1) {
            InputView inputView = this.auQ;
            i5 = this.auQ.auP;
            inputView.setSelection(i5);
            this.auQ.auP = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.auQ.auM;
        if (textWatcher != null) {
            textWatcher2 = this.auQ.auM;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.auQ.b(new com.baidu.tbadk.editortools.a(4, -1, this.auQ.getText().toString()));
        }
    }
}
