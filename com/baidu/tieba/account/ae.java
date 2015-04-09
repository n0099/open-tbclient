package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* loaded from: classes.dex */
class ae implements RadioGroup.OnCheckedChangeListener {
    final /* synthetic */ Register2Activity awk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(Register2Activity register2Activity) {
        this.awk = register2Activity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        EditText editText;
        if (i > 0) {
            RadioButton radioButton = (RadioButton) this.awk.findViewById(i);
            if (radioButton.isChecked()) {
                editText = this.awk.avP;
                editText.setText(radioButton.getText());
            }
        }
    }
}
