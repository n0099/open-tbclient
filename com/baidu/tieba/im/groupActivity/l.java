package com.baidu.tieba.im.groupActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements TextWatcher {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar) {
        this.a = eVar;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        ImageButton imageButton;
        TextView textView;
        ImageButton imageButton2;
        TextView textView2;
        editText = this.a.f;
        if (editText.getText().length() > 0) {
            imageButton2 = this.a.g;
            imageButton2.setVisibility(0);
            textView2 = this.a.h;
            textView2.setEnabled(true);
            return;
        }
        imageButton = this.a.g;
        imageButton.setVisibility(8);
        textView = this.a.h;
        textView.setEnabled(false);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }
}
