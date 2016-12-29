package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView avL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.avL = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.avL.avH;
        if (textWatcher != null) {
            textWatcher2 = this.avL.avH;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        Pattern pattern;
        SpannableStringBuilder fy;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.avL.avH;
        if (textWatcher != null) {
            textWatcher2 = this.avL.avH;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.avL.avJ;
        if (z) {
            pattern = InputView.avF;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fy = this.avL.fy(charSequence.toString());
            this.avL.avJ = false;
            this.avL.avK = i + i3;
            this.avL.setText(fy);
            return;
        }
        this.avL.avJ = true;
        i4 = this.avL.avK;
        if (i4 != -1) {
            InputView inputView = this.avL;
            i5 = this.avL.avK;
            inputView.setSelection(i5);
            this.avL.avK = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.avL.avH;
        if (textWatcher != null) {
            textWatcher2 = this.avL.avH;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.avL.b(new com.baidu.tbadk.editortools.a(4, -1, this.avL.getText().toString()));
        }
    }
}
