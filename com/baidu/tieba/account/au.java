package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* loaded from: classes.dex */
class au implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ Register2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(Register2Activity register2Activity) {
        this.a = register2Activity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        EditText editText;
        if (i > 0) {
            RadioButton radioButton = (RadioButton) this.a.findViewById(i);
            if (radioButton.isChecked()) {
                editText = this.a.x;
                editText.setText(radioButton.getText());
            }
        }
    }
}
