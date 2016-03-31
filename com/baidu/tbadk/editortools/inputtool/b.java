package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView avg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.avg = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.avg.avc;
        if (textWatcher != null) {
            textWatcher2 = this.avg.avc;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        Pattern pattern;
        SpannableStringBuilder ft;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.avg.avc;
        if (textWatcher != null) {
            textWatcher2 = this.avg.avc;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.avg.ave;
        if (z) {
            pattern = InputView.ava;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            ft = this.avg.ft(charSequence.toString());
            this.avg.ave = false;
            this.avg.avf = i + i3;
            this.avg.setText(ft);
            return;
        }
        this.avg.ave = true;
        i4 = this.avg.avf;
        if (i4 != -1) {
            InputView inputView = this.avg;
            i5 = this.avg.avf;
            inputView.setSelection(i5);
            this.avg.avf = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.avg.avc;
        if (textWatcher != null) {
            textWatcher2 = this.avg.avc;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.avg.b(new com.baidu.tbadk.editortools.a(4, -1, this.avg.getText().toString()));
        }
    }
}
