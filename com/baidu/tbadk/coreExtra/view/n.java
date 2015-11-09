package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ k akI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.akI = kVar;
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
            radioButton = this.akI.aks;
            if (compoundButton == radioButton) {
                radioGroup3 = this.akI.akq;
                radioGroup3.clearCheck();
                radioButton16 = this.akI.aks;
                radioButton16.setChecked(true);
                radioButton17 = this.akI.aks;
                drawable7 = this.akI.akG;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.akI.akt;
                radioButton18.setChecked(false);
                radioButton19 = this.akI.akt;
                drawable8 = this.akI.akH;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.akI.aku;
                radioButton20.setChecked(false);
                radioButton21 = this.akI.aku;
                drawable9 = this.akI.akH;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.akI.akt;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.akI.akq;
                    radioGroup2.clearCheck();
                    radioButton10 = this.akI.aks;
                    radioButton10.setChecked(false);
                    radioButton11 = this.akI.aks;
                    drawable4 = this.akI.akH;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.akI.akt;
                    radioButton12.setChecked(true);
                    radioButton13 = this.akI.akt;
                    drawable5 = this.akI.akG;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.akI.aku;
                    radioButton14.setChecked(false);
                    radioButton15 = this.akI.aku;
                    drawable6 = this.akI.akH;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.akI.aku;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.akI.akp;
                        radioGroup.clearCheck();
                        radioButton4 = this.akI.aks;
                        radioButton4.setChecked(false);
                        radioButton5 = this.akI.aks;
                        drawable = this.akI.akH;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.akI.akt;
                        radioButton6.setChecked(false);
                        radioButton7 = this.akI.akt;
                        drawable2 = this.akI.akH;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.akI.aku;
                        radioButton8.setChecked(true);
                        radioButton9 = this.akI.aku;
                        drawable3 = this.akI.akG;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.akI.ako;
            editText.setText(compoundButton.getText());
        }
    }
}
