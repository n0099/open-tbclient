package com.baidu.tbadk.coreExtra.view;

import android.widget.CompoundButton;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ r OC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar) {
        this.OC = rVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        EditText editText;
        if (z) {
            editText = this.OC.Ok;
            editText.setText(compoundButton.getText());
        }
    }
}
