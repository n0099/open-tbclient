package com.baidu.tieba.im.groupActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements TextWatcher {
    final /* synthetic */ e aZh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar) {
        this.aZh = eVar;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        ImageButton imageButton;
        TextView textView;
        ImageButton imageButton2;
        TextView textView2;
        editText = this.aZh.aYR;
        if (editText.getText().length() > 0) {
            imageButton2 = this.aZh.aYS;
            imageButton2.setVisibility(0);
            textView2 = this.aZh.aYT;
            textView2.setEnabled(true);
            return;
        }
        imageButton = this.aZh.aYS;
        imageButton.setVisibility(8);
        textView = this.aZh.aYT;
        textView.setEnabled(false);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }
}
