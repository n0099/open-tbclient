package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* loaded from: classes.dex */
class w implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ Register2Activity afR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Register2Activity register2Activity) {
        this.afR = register2Activity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        EditText editText;
        if (i > 0) {
            RadioButton radioButton = (RadioButton) this.afR.findViewById(i);
            if (radioButton.isChecked()) {
                editText = this.afR.afy;
                editText.setText(radioButton.getText());
            }
        }
    }
}
