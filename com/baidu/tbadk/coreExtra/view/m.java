package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j aoI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.aoI = jVar;
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
            radioButton = this.aoI.aos;
            if (compoundButton == radioButton) {
                radioGroup3 = this.aoI.aoq;
                radioGroup3.clearCheck();
                radioButton16 = this.aoI.aos;
                radioButton16.setChecked(true);
                radioButton17 = this.aoI.aos;
                drawable7 = this.aoI.aoG;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.aoI.aot;
                radioButton18.setChecked(false);
                radioButton19 = this.aoI.aot;
                drawable8 = this.aoI.aoH;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.aoI.aou;
                radioButton20.setChecked(false);
                radioButton21 = this.aoI.aou;
                drawable9 = this.aoI.aoH;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.aoI.aot;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.aoI.aoq;
                    radioGroup2.clearCheck();
                    radioButton10 = this.aoI.aos;
                    radioButton10.setChecked(false);
                    radioButton11 = this.aoI.aos;
                    drawable4 = this.aoI.aoH;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.aoI.aot;
                    radioButton12.setChecked(true);
                    radioButton13 = this.aoI.aot;
                    drawable5 = this.aoI.aoG;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.aoI.aou;
                    radioButton14.setChecked(false);
                    radioButton15 = this.aoI.aou;
                    drawable6 = this.aoI.aoH;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.aoI.aou;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.aoI.aop;
                        radioGroup.clearCheck();
                        radioButton4 = this.aoI.aos;
                        radioButton4.setChecked(false);
                        radioButton5 = this.aoI.aos;
                        drawable = this.aoI.aoH;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.aoI.aot;
                        radioButton6.setChecked(false);
                        radioButton7 = this.aoI.aot;
                        drawable2 = this.aoI.aoH;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.aoI.aou;
                        radioButton8.setChecked(true);
                        radioButton9 = this.aoI.aou;
                        drawable3 = this.aoI.aoG;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.aoI.aoo;
            editText.setText(compoundButton.getText());
        }
    }
}
