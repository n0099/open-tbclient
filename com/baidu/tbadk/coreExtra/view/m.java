package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j aok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.aok = jVar;
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
            radioButton = this.aok.anU;
            if (compoundButton == radioButton) {
                radioGroup3 = this.aok.anS;
                radioGroup3.clearCheck();
                radioButton16 = this.aok.anU;
                radioButton16.setChecked(true);
                radioButton17 = this.aok.anU;
                drawable7 = this.aok.aoi;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.aok.anV;
                radioButton18.setChecked(false);
                radioButton19 = this.aok.anV;
                drawable8 = this.aok.aoj;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.aok.anW;
                radioButton20.setChecked(false);
                radioButton21 = this.aok.anW;
                drawable9 = this.aok.aoj;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.aok.anV;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.aok.anS;
                    radioGroup2.clearCheck();
                    radioButton10 = this.aok.anU;
                    radioButton10.setChecked(false);
                    radioButton11 = this.aok.anU;
                    drawable4 = this.aok.aoj;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.aok.anV;
                    radioButton12.setChecked(true);
                    radioButton13 = this.aok.anV;
                    drawable5 = this.aok.aoi;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.aok.anW;
                    radioButton14.setChecked(false);
                    radioButton15 = this.aok.anW;
                    drawable6 = this.aok.aoj;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.aok.anW;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.aok.anR;
                        radioGroup.clearCheck();
                        radioButton4 = this.aok.anU;
                        radioButton4.setChecked(false);
                        radioButton5 = this.aok.anU;
                        drawable = this.aok.aoj;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.aok.anV;
                        radioButton6.setChecked(false);
                        radioButton7 = this.aok.anV;
                        drawable2 = this.aok.aoj;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.aok.anW;
                        radioButton8.setChecked(true);
                        radioButton9 = this.aok.anW;
                        drawable3 = this.aok.aoi;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.aok.anQ;
            editText.setText(compoundButton.getText());
        }
    }
}
