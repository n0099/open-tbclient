package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j ale;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.ale = jVar;
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
            radioButton = this.ale.akO;
            if (compoundButton == radioButton) {
                radioGroup3 = this.ale.akM;
                radioGroup3.clearCheck();
                radioButton16 = this.ale.akO;
                radioButton16.setChecked(true);
                radioButton17 = this.ale.akO;
                drawable7 = this.ale.alc;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.ale.akP;
                radioButton18.setChecked(false);
                radioButton19 = this.ale.akP;
                drawable8 = this.ale.ald;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.ale.akQ;
                radioButton20.setChecked(false);
                radioButton21 = this.ale.akQ;
                drawable9 = this.ale.ald;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.ale.akP;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.ale.akM;
                    radioGroup2.clearCheck();
                    radioButton10 = this.ale.akO;
                    radioButton10.setChecked(false);
                    radioButton11 = this.ale.akO;
                    drawable4 = this.ale.ald;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.ale.akP;
                    radioButton12.setChecked(true);
                    radioButton13 = this.ale.akP;
                    drawable5 = this.ale.alc;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.ale.akQ;
                    radioButton14.setChecked(false);
                    radioButton15 = this.ale.akQ;
                    drawable6 = this.ale.ald;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.ale.akQ;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.ale.akL;
                        radioGroup.clearCheck();
                        radioButton4 = this.ale.akO;
                        radioButton4.setChecked(false);
                        radioButton5 = this.ale.akO;
                        drawable = this.ale.ald;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.ale.akP;
                        radioButton6.setChecked(false);
                        radioButton7 = this.ale.akP;
                        drawable2 = this.ale.ald;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.ale.akQ;
                        radioButton8.setChecked(true);
                        radioButton9 = this.ale.akQ;
                        drawable3 = this.ale.alc;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.ale.akK;
            editText.setText(compoundButton.getText());
        }
    }
}
