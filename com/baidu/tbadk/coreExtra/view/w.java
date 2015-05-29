package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ t agi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.agi = tVar;
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
            radioButton = this.agi.afS;
            if (compoundButton == radioButton) {
                radioGroup3 = this.agi.afQ;
                radioGroup3.clearCheck();
                radioButton16 = this.agi.afS;
                radioButton16.setChecked(true);
                radioButton17 = this.agi.afS;
                drawable7 = this.agi.agg;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.agi.afT;
                radioButton18.setChecked(false);
                radioButton19 = this.agi.afT;
                drawable8 = this.agi.agh;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.agi.afU;
                radioButton20.setChecked(false);
                radioButton21 = this.agi.afU;
                drawable9 = this.agi.agh;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.agi.afT;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.agi.afQ;
                    radioGroup2.clearCheck();
                    radioButton10 = this.agi.afS;
                    radioButton10.setChecked(false);
                    radioButton11 = this.agi.afS;
                    drawable4 = this.agi.agh;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.agi.afT;
                    radioButton12.setChecked(true);
                    radioButton13 = this.agi.afT;
                    drawable5 = this.agi.agg;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.agi.afU;
                    radioButton14.setChecked(false);
                    radioButton15 = this.agi.afU;
                    drawable6 = this.agi.agh;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.agi.afU;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.agi.afP;
                        radioGroup.clearCheck();
                        radioButton4 = this.agi.afS;
                        radioButton4.setChecked(false);
                        radioButton5 = this.agi.afS;
                        drawable = this.agi.agh;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.agi.afT;
                        radioButton6.setChecked(false);
                        radioButton7 = this.agi.afT;
                        drawable2 = this.agi.agh;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.agi.afU;
                        radioButton8.setChecked(true);
                        radioButton9 = this.agi.afU;
                        drawable3 = this.agi.agg;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.agi.afO;
            editText.setText(compoundButton.getText());
        }
    }
}
