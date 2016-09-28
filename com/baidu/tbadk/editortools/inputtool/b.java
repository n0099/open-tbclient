package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView avu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.avu = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.avu.avq;
        if (textWatcher != null) {
            textWatcher2 = this.avu.avq;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        Pattern pattern;
        SpannableStringBuilder fz;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.avu.avq;
        if (textWatcher != null) {
            textWatcher2 = this.avu.avq;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.avu.avs;
        if (z) {
            pattern = InputView.avo;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fz = this.avu.fz(charSequence.toString());
            this.avu.avs = false;
            this.avu.avt = i + i3;
            this.avu.setText(fz);
            return;
        }
        this.avu.avs = true;
        i4 = this.avu.avt;
        if (i4 != -1) {
            InputView inputView = this.avu;
            i5 = this.avu.avt;
            inputView.setSelection(i5);
            this.avu.avt = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.avu.avq;
        if (textWatcher != null) {
            textWatcher2 = this.avu.avq;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.avu.b(new com.baidu.tbadk.editortools.a(4, -1, this.avu.getText().toString()));
        }
    }
}
