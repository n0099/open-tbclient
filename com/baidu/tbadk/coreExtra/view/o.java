package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ l alp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar) {
        this.alp = lVar;
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
            radioButton = this.alp.akZ;
            if (compoundButton == radioButton) {
                radioGroup3 = this.alp.akX;
                radioGroup3.clearCheck();
                radioButton16 = this.alp.akZ;
                radioButton16.setChecked(true);
                radioButton17 = this.alp.akZ;
                drawable7 = this.alp.aln;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.alp.ala;
                radioButton18.setChecked(false);
                radioButton19 = this.alp.ala;
                drawable8 = this.alp.alo;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.alp.alb;
                radioButton20.setChecked(false);
                radioButton21 = this.alp.alb;
                drawable9 = this.alp.alo;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.alp.ala;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.alp.akX;
                    radioGroup2.clearCheck();
                    radioButton10 = this.alp.akZ;
                    radioButton10.setChecked(false);
                    radioButton11 = this.alp.akZ;
                    drawable4 = this.alp.alo;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.alp.ala;
                    radioButton12.setChecked(true);
                    radioButton13 = this.alp.ala;
                    drawable5 = this.alp.aln;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.alp.alb;
                    radioButton14.setChecked(false);
                    radioButton15 = this.alp.alb;
                    drawable6 = this.alp.alo;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.alp.alb;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.alp.akW;
                        radioGroup.clearCheck();
                        radioButton4 = this.alp.akZ;
                        radioButton4.setChecked(false);
                        radioButton5 = this.alp.akZ;
                        drawable = this.alp.alo;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.alp.ala;
                        radioButton6.setChecked(false);
                        radioButton7 = this.alp.ala;
                        drawable2 = this.alp.alo;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.alp.alb;
                        radioButton8.setChecked(true);
                        radioButton9 = this.alp.alb;
                        drawable3 = this.alp.aln;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.alp.akV;
            editText.setText(compoundButton.getText());
        }
    }
}
