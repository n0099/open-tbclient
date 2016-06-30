package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView arV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.arV = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.arV.arR;
        if (textWatcher != null) {
            textWatcher2 = this.arV.arR;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        Pattern pattern;
        SpannableStringBuilder fw;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.arV.arR;
        if (textWatcher != null) {
            textWatcher2 = this.arV.arR;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.arV.arT;
        if (z) {
            pattern = InputView.arP;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fw = this.arV.fw(charSequence.toString());
            this.arV.arT = false;
            this.arV.arU = i + i3;
            this.arV.setText(fw);
            return;
        }
        this.arV.arT = true;
        i4 = this.arV.arU;
        if (i4 != -1) {
            InputView inputView = this.arV;
            i5 = this.arV.arU;
            inputView.setSelection(i5);
            this.arV.arU = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.arV.arR;
        if (textWatcher != null) {
            textWatcher2 = this.arV.arR;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.arV.b(new com.baidu.tbadk.editortools.a(4, -1, this.arV.getText().toString()));
        }
    }
}
