package com.baidu.tbadk.editortools.inputtool;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements TextWatcher {
    final /* synthetic */ InputView asK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InputView inputView) {
        this.asK = inputView;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.asK.asG;
        if (textWatcher != null) {
            textWatcher2 = this.asK.asG;
            textWatcher2.beforeTextChanged(charSequence, i, i2, i3);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        boolean z;
        Pattern pattern;
        SpannableStringBuilder fu;
        int i4;
        int i5;
        TextWatcher textWatcher2;
        textWatcher = this.asK.asG;
        if (textWatcher != null) {
            textWatcher2 = this.asK.asG;
            textWatcher2.onTextChanged(charSequence, i, i2, i3);
        }
        z = this.asK.asI;
        if (z) {
            pattern = InputView.asE;
            if (!pattern.matcher(charSequence.subSequence(i, i + i3)).find()) {
                return;
            }
            fu = this.asK.fu(charSequence.toString());
            this.asK.asI = false;
            this.asK.asJ = i + i3;
            this.asK.setText(fu);
            return;
        }
        this.asK.asI = true;
        i4 = this.asK.asJ;
        if (i4 != -1) {
            InputView inputView = this.asK;
            i5 = this.asK.asJ;
            inputView.setSelection(i5);
            this.asK.asJ = -1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        TextWatcher textWatcher2;
        textWatcher = this.asK.asG;
        if (textWatcher != null) {
            textWatcher2 = this.asK.asG;
            textWatcher2.afterTextChanged(editable);
        }
        if (editable != null && editable.toString().trim() != null) {
            this.asK.b(new com.baidu.tbadk.editortools.a(4, -1, this.asK.getText().toString()));
        }
    }
}
