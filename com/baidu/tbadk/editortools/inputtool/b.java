package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView awo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.awo = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.awo.awk;
        if (textWatcher != null) {
            textWatcher2 = this.awo.awk;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        Pattern pattern;
        SpannableStringBuilder fC;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.awo.awk;
        if (textWatcher != null) {
            textWatcher2 = this.awo.awk;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.awo.awm;
        if (z) {
            pattern = InputView.awi;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fC = this.awo.fC(charSequence.toString());
            this.awo.awm = false;
            this.awo.awn = i + i3;
            this.awo.setText(fC);
            return;
        }
        this.awo.awm = true;
        i4 = this.awo.awn;
        if (i4 != -1) {
            InputView inputView = this.awo;
            i5 = this.awo.awn;
            inputView.setSelection(i5);
            this.awo.awn = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.awo.awk;
        if (textWatcher != null) {
            textWatcher2 = this.awo.awk;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.awo.b(new com.baidu.tbadk.editortools.a(4, -1, this.awo.getText().toString()));
        }
    }
}
