package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j auO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.auO = jVar;
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
            radioButton = this.auO.auy;
            if (compoundButton == radioButton) {
                radioGroup3 = this.auO.auw;
                radioGroup3.clearCheck();
                radioButton16 = this.auO.auy;
                radioButton16.setChecked(true);
                radioButton17 = this.auO.auy;
                drawable7 = this.auO.auM;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.auO.auz;
                radioButton18.setChecked(false);
                radioButton19 = this.auO.auz;
                drawable8 = this.auO.auN;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.auO.auA;
                radioButton20.setChecked(false);
                radioButton21 = this.auO.auA;
                drawable9 = this.auO.auN;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.auO.auz;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.auO.auw;
                    radioGroup2.clearCheck();
                    radioButton10 = this.auO.auy;
                    radioButton10.setChecked(false);
                    radioButton11 = this.auO.auy;
                    drawable4 = this.auO.auN;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.auO.auz;
                    radioButton12.setChecked(true);
                    radioButton13 = this.auO.auz;
                    drawable5 = this.auO.auM;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.auO.auA;
                    radioButton14.setChecked(false);
                    radioButton15 = this.auO.auA;
                    drawable6 = this.auO.auN;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.auO.auA;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.auO.auv;
                        radioGroup.clearCheck();
                        radioButton4 = this.auO.auy;
                        radioButton4.setChecked(false);
                        radioButton5 = this.auO.auy;
                        drawable = this.auO.auN;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.auO.auz;
                        radioButton6.setChecked(false);
                        radioButton7 = this.auO.auz;
                        drawable2 = this.auO.auN;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.auO.auA;
                        radioButton8.setChecked(true);
                        radioButton9 = this.auO.auA;
                        drawable3 = this.auO.auM;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.auO.auu;
            editText.setText(compoundButton.getText());
        }
    }
}
