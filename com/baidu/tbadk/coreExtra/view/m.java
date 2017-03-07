package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j atF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.atF = jVar;
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
            radioButton = this.atF.atp;
            if (compoundButton == radioButton) {
                radioGroup3 = this.atF.atn;
                radioGroup3.clearCheck();
                radioButton16 = this.atF.atp;
                radioButton16.setChecked(true);
                radioButton17 = this.atF.atp;
                drawable7 = this.atF.atD;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.atF.atq;
                radioButton18.setChecked(false);
                radioButton19 = this.atF.atq;
                drawable8 = this.atF.atE;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.atF.atr;
                radioButton20.setChecked(false);
                radioButton21 = this.atF.atr;
                drawable9 = this.atF.atE;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.atF.atq;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.atF.atn;
                    radioGroup2.clearCheck();
                    radioButton10 = this.atF.atp;
                    radioButton10.setChecked(false);
                    radioButton11 = this.atF.atp;
                    drawable4 = this.atF.atE;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.atF.atq;
                    radioButton12.setChecked(true);
                    radioButton13 = this.atF.atq;
                    drawable5 = this.atF.atD;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.atF.atr;
                    radioButton14.setChecked(false);
                    radioButton15 = this.atF.atr;
                    drawable6 = this.atF.atE;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.atF.atr;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.atF.atm;
                        radioGroup.clearCheck();
                        radioButton4 = this.atF.atp;
                        radioButton4.setChecked(false);
                        radioButton5 = this.atF.atp;
                        drawable = this.atF.atE;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.atF.atq;
                        radioButton6.setChecked(false);
                        radioButton7 = this.atF.atq;
                        drawable2 = this.atF.atE;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.atF.atr;
                        radioButton8.setChecked(true);
                        radioButton9 = this.atF.atr;
                        drawable3 = this.atF.atD;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.atF.atl;
            editText.setText(compoundButton.getText());
        }
    }
}
