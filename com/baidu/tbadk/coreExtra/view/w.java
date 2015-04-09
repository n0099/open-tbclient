package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ t afh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.afh = tVar;
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
            radioButton = this.afh.aeQ;
            if (compoundButton == radioButton) {
                radioGroup3 = this.afh.aeO;
                radioGroup3.clearCheck();
                radioButton16 = this.afh.aeQ;
                radioButton16.setChecked(true);
                radioButton17 = this.afh.aeQ;
                drawable7 = this.afh.aff;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.afh.aeR;
                radioButton18.setChecked(false);
                radioButton19 = this.afh.aeR;
                drawable8 = this.afh.afg;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.afh.aeS;
                radioButton20.setChecked(false);
                radioButton21 = this.afh.aeS;
                drawable9 = this.afh.afg;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.afh.aeR;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.afh.aeO;
                    radioGroup2.clearCheck();
                    radioButton10 = this.afh.aeQ;
                    radioButton10.setChecked(false);
                    radioButton11 = this.afh.aeQ;
                    drawable4 = this.afh.afg;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.afh.aeR;
                    radioButton12.setChecked(true);
                    radioButton13 = this.afh.aeR;
                    drawable5 = this.afh.aff;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.afh.aeS;
                    radioButton14.setChecked(false);
                    radioButton15 = this.afh.aeS;
                    drawable6 = this.afh.afg;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.afh.aeS;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.afh.aeN;
                        radioGroup.clearCheck();
                        radioButton4 = this.afh.aeQ;
                        radioButton4.setChecked(false);
                        radioButton5 = this.afh.aeQ;
                        drawable = this.afh.afg;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.afh.aeR;
                        radioButton6.setChecked(false);
                        radioButton7 = this.afh.aeR;
                        drawable2 = this.afh.afg;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.afh.aeS;
                        radioButton8.setChecked(true);
                        radioButton9 = this.afh.aeS;
                        drawable3 = this.afh.aff;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.afh.aeK;
            editText.setText(compoundButton.getText());
        }
    }
}
