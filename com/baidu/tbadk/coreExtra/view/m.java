package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j aoK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.aoK = jVar;
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
            radioButton = this.aoK.aou;
            if (compoundButton == radioButton) {
                radioGroup3 = this.aoK.aos;
                radioGroup3.clearCheck();
                radioButton16 = this.aoK.aou;
                radioButton16.setChecked(true);
                radioButton17 = this.aoK.aou;
                drawable7 = this.aoK.aoI;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.aoK.aov;
                radioButton18.setChecked(false);
                radioButton19 = this.aoK.aov;
                drawable8 = this.aoK.aoJ;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.aoK.aow;
                radioButton20.setChecked(false);
                radioButton21 = this.aoK.aow;
                drawable9 = this.aoK.aoJ;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.aoK.aov;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.aoK.aos;
                    radioGroup2.clearCheck();
                    radioButton10 = this.aoK.aou;
                    radioButton10.setChecked(false);
                    radioButton11 = this.aoK.aou;
                    drawable4 = this.aoK.aoJ;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.aoK.aov;
                    radioButton12.setChecked(true);
                    radioButton13 = this.aoK.aov;
                    drawable5 = this.aoK.aoI;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.aoK.aow;
                    radioButton14.setChecked(false);
                    radioButton15 = this.aoK.aow;
                    drawable6 = this.aoK.aoJ;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.aoK.aow;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.aoK.aor;
                        radioGroup.clearCheck();
                        radioButton4 = this.aoK.aou;
                        radioButton4.setChecked(false);
                        radioButton5 = this.aoK.aou;
                        drawable = this.aoK.aoJ;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.aoK.aov;
                        radioButton6.setChecked(false);
                        radioButton7 = this.aoK.aov;
                        drawable2 = this.aoK.aoJ;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.aoK.aow;
                        radioButton8.setChecked(true);
                        radioButton9 = this.aoK.aow;
                        drawable3 = this.aoK.aoI;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.aoK.aoq;
            editText.setText(compoundButton.getText());
        }
    }
}
