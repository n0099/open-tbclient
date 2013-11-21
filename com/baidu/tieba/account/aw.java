package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* loaded from: classes.dex */
class aw implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(Register2Activity register2Activity) {
        this.f1060a = register2Activity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        EditText editText;
        if (i > 0) {
            RadioButton radioButton = (RadioButton) this.f1060a.findViewById(i);
            if (radioButton.isChecked()) {
                editText = this.f1060a.t;
                editText.setText(radioButton.getText());
            }
        }
    }
}
