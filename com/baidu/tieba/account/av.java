package com.baidu.tieba.account;

import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* loaded from: classes.dex */
class av implements RadioGroup.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f889a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(Register2Activity register2Activity) {
        this.f889a = register2Activity;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        EditText editText;
        if (i > 0) {
            RadioButton radioButton = (RadioButton) this.f889a.findViewById(i);
            if (radioButton.isChecked()) {
                editText = this.f889a.x;
                editText.setText(radioButton.getText());
            }
        }
    }
}
