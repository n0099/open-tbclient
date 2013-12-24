package com.baidu.tieba.account;

import android.widget.CompoundButton;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar) {
        this.a = xVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        EditText editText;
        if (z) {
            editText = this.a.c;
            editText.setText(compoundButton.getText());
        }
    }
}
