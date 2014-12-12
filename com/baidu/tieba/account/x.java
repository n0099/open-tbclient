package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* loaded from: classes.dex */
class x implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ Register2Activity ani;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Register2Activity register2Activity) {
        this.ani = register2Activity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        EditText editText;
        if (i > 0) {
            RadioButton radioButton = (RadioButton) this.ani.findViewById(i);
            if (radioButton.isChecked()) {
                editText = this.ani.amP;
                editText.setText(radioButton.getText());
            }
        }
    }
}
