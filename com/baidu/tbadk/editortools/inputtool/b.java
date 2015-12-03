package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView ask;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.ask = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.ask.asg;
        if (textWatcher != null) {
            textWatcher2 = this.ask.asg;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        Pattern pattern;
        SpannableStringBuilder fj;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.ask.asg;
        if (textWatcher != null) {
            textWatcher2 = this.ask.asg;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.ask.asi;
        if (z) {
            pattern = InputView.ase;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fj = this.ask.fj(charSequence.toString());
            this.ask.asi = false;
            this.ask.asj = i + i3;
            this.ask.setText(fj);
            return;
        }
        this.ask.asi = true;
        i4 = this.ask.asj;
        if (i4 != -1) {
            InputView inputView = this.ask;
            i5 = this.ask.asj;
            inputView.setSelection(i5);
            this.ask.asj = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.ask.asg;
        if (textWatcher != null) {
            textWatcher2 = this.ask.asg;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.ask.b(new com.baidu.tbadk.editortools.a(4, -1, this.ask.getText().toString()));
        }
    }
}
