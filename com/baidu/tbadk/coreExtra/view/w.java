package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ t aeZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.aeZ = tVar;
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
            radioButton = this.aeZ.aeI;
            if (compoundButton == radioButton) {
                radioGroup3 = this.aeZ.aeG;
                radioGroup3.clearCheck();
                radioButton16 = this.aeZ.aeI;
                radioButton16.setChecked(true);
                radioButton17 = this.aeZ.aeI;
                drawable7 = this.aeZ.aeX;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.aeZ.aeJ;
                radioButton18.setChecked(false);
                radioButton19 = this.aeZ.aeJ;
                drawable8 = this.aeZ.aeY;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.aeZ.aeK;
                radioButton20.setChecked(false);
                radioButton21 = this.aeZ.aeK;
                drawable9 = this.aeZ.aeY;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.aeZ.aeJ;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.aeZ.aeG;
                    radioGroup2.clearCheck();
                    radioButton10 = this.aeZ.aeI;
                    radioButton10.setChecked(false);
                    radioButton11 = this.aeZ.aeI;
                    drawable4 = this.aeZ.aeY;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.aeZ.aeJ;
                    radioButton12.setChecked(true);
                    radioButton13 = this.aeZ.aeJ;
                    drawable5 = this.aeZ.aeX;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.aeZ.aeK;
                    radioButton14.setChecked(false);
                    radioButton15 = this.aeZ.aeK;
                    drawable6 = this.aeZ.aeY;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.aeZ.aeK;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.aeZ.aeF;
                        radioGroup.clearCheck();
                        radioButton4 = this.aeZ.aeI;
                        radioButton4.setChecked(false);
                        radioButton5 = this.aeZ.aeI;
                        drawable = this.aeZ.aeY;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.aeZ.aeJ;
                        radioButton6.setChecked(false);
                        radioButton7 = this.aeZ.aeJ;
                        drawable2 = this.aeZ.aeY;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.aeZ.aeK;
                        radioButton8.setChecked(true);
                        radioButton9 = this.aeZ.aeK;
                        drawable3 = this.aeZ.aeX;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.aeZ.aeC;
            editText.setText(compoundButton.getText());
        }
    }
}
