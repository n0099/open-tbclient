package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* loaded from: classes.dex */
class aj implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ Register2Activity axQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(Register2Activity register2Activity) {
        this.axQ = register2Activity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        EditText editText;
        if (i > 0) {
            RadioButton radioButton = (RadioButton) this.axQ.findViewById(i);
            if (radioButton.isChecked()) {
                editText = this.axQ.axv;
                editText.setText(radioButton.getText());
            }
        }
    }
}
