package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j ape;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.ape = jVar;
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
            radioButton = this.ape.aoO;
            if (compoundButton == radioButton) {
                radioGroup3 = this.ape.aoM;
                radioGroup3.clearCheck();
                radioButton16 = this.ape.aoO;
                radioButton16.setChecked(true);
                radioButton17 = this.ape.aoO;
                drawable7 = this.ape.apc;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.ape.aoP;
                radioButton18.setChecked(false);
                radioButton19 = this.ape.aoP;
                drawable8 = this.ape.apd;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.ape.aoQ;
                radioButton20.setChecked(false);
                radioButton21 = this.ape.aoQ;
                drawable9 = this.ape.apd;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.ape.aoP;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.ape.aoM;
                    radioGroup2.clearCheck();
                    radioButton10 = this.ape.aoO;
                    radioButton10.setChecked(false);
                    radioButton11 = this.ape.aoO;
                    drawable4 = this.ape.apd;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.ape.aoP;
                    radioButton12.setChecked(true);
                    radioButton13 = this.ape.aoP;
                    drawable5 = this.ape.apc;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.ape.aoQ;
                    radioButton14.setChecked(false);
                    radioButton15 = this.ape.aoQ;
                    drawable6 = this.ape.apd;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.ape.aoQ;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.ape.aoL;
                        radioGroup.clearCheck();
                        radioButton4 = this.ape.aoO;
                        radioButton4.setChecked(false);
                        radioButton5 = this.ape.aoO;
                        drawable = this.ape.apd;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.ape.aoP;
                        radioButton6.setChecked(false);
                        radioButton7 = this.ape.aoP;
                        drawable2 = this.ape.apd;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.ape.aoQ;
                        radioButton8.setChecked(true);
                        radioButton9 = this.ape.aoQ;
                        drawable3 = this.ape.apc;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.ape.aoK;
            editText.setText(compoundButton.getText());
        }
    }
}
