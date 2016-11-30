package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j apD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.apD = jVar;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        RadioButton radioButton;
        RadioButton radioButton2;
        RadioButton radioButton3;
        RadioGroup radioGroup;
        RadioButton radioButton4;
        RadioButton radioButton5;
        Drawable drawable;
        RadioButton radioButton6;
        RadioButton radioButton7;
        Drawable drawable2;
        RadioButton radioButton8;
        RadioButton radioButton9;
        Drawable drawable3;
        RadioGroup radioGroup2;
        RadioButton radioButton10;
        RadioButton radioButton11;
        Drawable drawable4;
        RadioButton radioButton12;
        RadioButton radioButton13;
        Drawable drawable5;
        RadioButton radioButton14;
        RadioButton radioButton15;
        Drawable drawable6;
        EditText editText;
        RadioGroup radioGroup3;
        RadioButton radioButton16;
        RadioButton radioButton17;
        Drawable drawable7;
        RadioButton radioButton18;
        RadioButton radioButton19;
        Drawable drawable8;
        RadioButton radioButton20;
        RadioButton radioButton21;
        Drawable drawable9;
        if (z) {
            radioButton = this.apD.apm;
            if (compoundButton == radioButton) {
                radioGroup3 = this.apD.apk;
                radioGroup3.clearCheck();
                radioButton16 = this.apD.apm;
                radioButton16.setChecked(true);
                radioButton17 = this.apD.apm;
                drawable7 = this.apD.apB;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.apD.apn;
                radioButton18.setChecked(false);
                radioButton19 = this.apD.apn;
                drawable8 = this.apD.apC;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.apD.apo;
                radioButton20.setChecked(false);
                radioButton21 = this.apD.apo;
                drawable9 = this.apD.apC;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.apD.apn;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.apD.apk;
                    radioGroup2.clearCheck();
                    radioButton10 = this.apD.apm;
                    radioButton10.setChecked(false);
                    radioButton11 = this.apD.apm;
                    drawable4 = this.apD.apC;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.apD.apn;
                    radioButton12.setChecked(true);
                    radioButton13 = this.apD.apn;
                    drawable5 = this.apD.apB;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.apD.apo;
                    radioButton14.setChecked(false);
                    radioButton15 = this.apD.apo;
                    drawable6 = this.apD.apC;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.apD.apo;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.apD.apj;
                        radioGroup.clearCheck();
                        radioButton4 = this.apD.apm;
                        radioButton4.setChecked(false);
                        radioButton5 = this.apD.apm;
                        drawable = this.apD.apC;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.apD.apn;
                        radioButton6.setChecked(false);
                        radioButton7 = this.apD.apn;
                        drawable2 = this.apD.apC;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.apD.apo;
                        radioButton8.setChecked(true);
                        radioButton9 = this.apD.apo;
                        drawable3 = this.apD.apB;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.apD.api;
            editText.setText(compoundButton.getText());
        }
    }
}
