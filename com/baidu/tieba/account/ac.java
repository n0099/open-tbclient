package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* loaded from: classes.dex */
class ac implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ Register2Activity aFh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Register2Activity register2Activity) {
        this.aFh = register2Activity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        EditText editText;
        if (i > 0) {
            RadioButton radioButton = (RadioButton) this.aFh.findViewById(i);
            if (radioButton.isChecked()) {
                editText = this.aFh.aEM;
                editText.setText(radioButton.getText());
            }
        }
    }
}
