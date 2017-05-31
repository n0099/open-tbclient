package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j atL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.atL = jVar;
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
            radioButton = this.atL.atv;
            if (compoundButton == radioButton) {
                radioGroup3 = this.atL.att;
                radioGroup3.clearCheck();
                radioButton16 = this.atL.atv;
                radioButton16.setChecked(true);
                radioButton17 = this.atL.atv;
                drawable7 = this.atL.atJ;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.atL.atw;
                radioButton18.setChecked(false);
                radioButton19 = this.atL.atw;
                drawable8 = this.atL.atK;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.atL.atx;
                radioButton20.setChecked(false);
                radioButton21 = this.atL.atx;
                drawable9 = this.atL.atK;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.atL.atw;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.atL.att;
                    radioGroup2.clearCheck();
                    radioButton10 = this.atL.atv;
                    radioButton10.setChecked(false);
                    radioButton11 = this.atL.atv;
                    drawable4 = this.atL.atK;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.atL.atw;
                    radioButton12.setChecked(true);
                    radioButton13 = this.atL.atw;
                    drawable5 = this.atL.atJ;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.atL.atx;
                    radioButton14.setChecked(false);
                    radioButton15 = this.atL.atx;
                    drawable6 = this.atL.atK;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.atL.atx;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.atL.ats;
                        radioGroup.clearCheck();
                        radioButton4 = this.atL.atv;
                        radioButton4.setChecked(false);
                        radioButton5 = this.atL.atv;
                        drawable = this.atL.atK;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.atL.atw;
                        radioButton6.setChecked(false);
                        radioButton7 = this.atL.atw;
                        drawable2 = this.atL.atK;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.atL.atx;
                        radioButton8.setChecked(true);
                        radioButton9 = this.atL.atx;
                        drawable3 = this.atL.atJ;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.atL.atr;
            editText.setText(compoundButton.getText());
        }
    }
}
