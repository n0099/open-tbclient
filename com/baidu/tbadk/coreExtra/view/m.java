package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j atV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.atV = jVar;
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
            radioButton = this.atV.atF;
            if (compoundButton == radioButton) {
                radioGroup3 = this.atV.atD;
                radioGroup3.clearCheck();
                radioButton16 = this.atV.atF;
                radioButton16.setChecked(true);
                radioButton17 = this.atV.atF;
                drawable7 = this.atV.atT;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.atV.atG;
                radioButton18.setChecked(false);
                radioButton19 = this.atV.atG;
                drawable8 = this.atV.atU;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.atV.atH;
                radioButton20.setChecked(false);
                radioButton21 = this.atV.atH;
                drawable9 = this.atV.atU;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.atV.atG;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.atV.atD;
                    radioGroup2.clearCheck();
                    radioButton10 = this.atV.atF;
                    radioButton10.setChecked(false);
                    radioButton11 = this.atV.atF;
                    drawable4 = this.atV.atU;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.atV.atG;
                    radioButton12.setChecked(true);
                    radioButton13 = this.atV.atG;
                    drawable5 = this.atV.atT;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.atV.atH;
                    radioButton14.setChecked(false);
                    radioButton15 = this.atV.atH;
                    drawable6 = this.atV.atU;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.atV.atH;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.atV.atC;
                        radioGroup.clearCheck();
                        radioButton4 = this.atV.atF;
                        radioButton4.setChecked(false);
                        radioButton5 = this.atV.atF;
                        drawable = this.atV.atU;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.atV.atG;
                        radioButton6.setChecked(false);
                        radioButton7 = this.atV.atG;
                        drawable2 = this.atV.atU;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.atV.atH;
                        radioButton8.setChecked(true);
                        radioButton9 = this.atV.atH;
                        drawable3 = this.atV.atT;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.atV.atB;
            editText.setText(compoundButton.getText());
        }
    }
}
