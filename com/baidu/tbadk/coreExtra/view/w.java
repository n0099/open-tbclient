package com.baidu.tbadk.coreExtra.view;

import android.widget.CompoundButton;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ s a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(s sVar) {
        this.a = sVar;
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
