package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ k alH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.alH = kVar;
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
            radioButton = this.alH.alr;
            if (compoundButton == radioButton) {
                radioGroup3 = this.alH.alp;
                radioGroup3.clearCheck();
                radioButton16 = this.alH.alr;
                radioButton16.setChecked(true);
                radioButton17 = this.alH.alr;
                drawable7 = this.alH.alF;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.alH.als;
                radioButton18.setChecked(false);
                radioButton19 = this.alH.als;
                drawable8 = this.alH.alG;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.alH.alt;
                radioButton20.setChecked(false);
                radioButton21 = this.alH.alt;
                drawable9 = this.alH.alG;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.alH.als;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.alH.alp;
                    radioGroup2.clearCheck();
                    radioButton10 = this.alH.alr;
                    radioButton10.setChecked(false);
                    radioButton11 = this.alH.alr;
                    drawable4 = this.alH.alG;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.alH.als;
                    radioButton12.setChecked(true);
                    radioButton13 = this.alH.als;
                    drawable5 = this.alH.alF;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.alH.alt;
                    radioButton14.setChecked(false);
                    radioButton15 = this.alH.alt;
                    drawable6 = this.alH.alG;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.alH.alt;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.alH.alo;
                        radioGroup.clearCheck();
                        radioButton4 = this.alH.alr;
                        radioButton4.setChecked(false);
                        radioButton5 = this.alH.alr;
                        drawable = this.alH.alG;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.alH.als;
                        radioButton6.setChecked(false);
                        radioButton7 = this.alH.als;
                        drawable2 = this.alH.alG;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.alH.alt;
                        radioButton8.setChecked(true);
                        radioButton9 = this.alH.alt;
                        drawable3 = this.alH.alF;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.alH.aln;
            editText.setText(compoundButton.getText());
        }
    }
}
