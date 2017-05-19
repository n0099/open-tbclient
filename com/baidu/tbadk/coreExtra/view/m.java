package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j aub;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.aub = jVar;
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
            radioButton = this.aub.atL;
            if (compoundButton == radioButton) {
                radioGroup3 = this.aub.atJ;
                radioGroup3.clearCheck();
                radioButton16 = this.aub.atL;
                radioButton16.setChecked(true);
                radioButton17 = this.aub.atL;
                drawable7 = this.aub.atZ;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.aub.atM;
                radioButton18.setChecked(false);
                radioButton19 = this.aub.atM;
                drawable8 = this.aub.aua;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.aub.atN;
                radioButton20.setChecked(false);
                radioButton21 = this.aub.atN;
                drawable9 = this.aub.aua;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.aub.atM;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.aub.atJ;
                    radioGroup2.clearCheck();
                    radioButton10 = this.aub.atL;
                    radioButton10.setChecked(false);
                    radioButton11 = this.aub.atL;
                    drawable4 = this.aub.aua;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.aub.atM;
                    radioButton12.setChecked(true);
                    radioButton13 = this.aub.atM;
                    drawable5 = this.aub.atZ;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.aub.atN;
                    radioButton14.setChecked(false);
                    radioButton15 = this.aub.atN;
                    drawable6 = this.aub.aua;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.aub.atN;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.aub.atI;
                        radioGroup.clearCheck();
                        radioButton4 = this.aub.atL;
                        radioButton4.setChecked(false);
                        radioButton5 = this.aub.atL;
                        drawable = this.aub.aua;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.aub.atM;
                        radioButton6.setChecked(false);
                        radioButton7 = this.aub.atM;
                        drawable2 = this.aub.aua;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.aub.atN;
                        radioButton8.setChecked(true);
                        radioButton9 = this.aub.atN;
                        drawable3 = this.aub.atZ;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.aub.atH;
            editText.setText(compoundButton.getText());
        }
    }
}
