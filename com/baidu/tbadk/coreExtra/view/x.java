package com.baidu.tbadk.coreExtra.view;

import android.widget.CompoundButton;
import android.widget.EditText;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ t UV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.UV = tVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        EditText editText;
        if (z) {
            editText = this.UV.UD;
            editText.setText(compoundButton.getText());
        }
    }
}
