package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* loaded from: classes.dex */
class y implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ Register2Activity aoa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(Register2Activity register2Activity) {
        this.aoa = register2Activity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        EditText editText;
        if (i > 0) {
            RadioButton radioButton = (RadioButton) this.aoa.findViewById(i);
            if (radioButton.isChecked()) {
                editText = this.aoa.anH;
                editText.setText(radioButton.getText());
            }
        }
    }
}
