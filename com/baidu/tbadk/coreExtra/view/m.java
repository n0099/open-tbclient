package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j apa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.apa = jVar;
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
            radioButton = this.apa.aoK;
            if (compoundButton == radioButton) {
                radioGroup3 = this.apa.aoI;
                radioGroup3.clearCheck();
                radioButton16 = this.apa.aoK;
                radioButton16.setChecked(true);
                radioButton17 = this.apa.aoK;
                drawable7 = this.apa.aoY;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.apa.aoL;
                radioButton18.setChecked(false);
                radioButton19 = this.apa.aoL;
                drawable8 = this.apa.aoZ;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.apa.aoM;
                radioButton20.setChecked(false);
                radioButton21 = this.apa.aoM;
                drawable9 = this.apa.aoZ;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.apa.aoL;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.apa.aoI;
                    radioGroup2.clearCheck();
                    radioButton10 = this.apa.aoK;
                    radioButton10.setChecked(false);
                    radioButton11 = this.apa.aoK;
                    drawable4 = this.apa.aoZ;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.apa.aoL;
                    radioButton12.setChecked(true);
                    radioButton13 = this.apa.aoL;
                    drawable5 = this.apa.aoY;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.apa.aoM;
                    radioButton14.setChecked(false);
                    radioButton15 = this.apa.aoM;
                    drawable6 = this.apa.aoZ;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.apa.aoM;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.apa.aoH;
                        radioGroup.clearCheck();
                        radioButton4 = this.apa.aoK;
                        radioButton4.setChecked(false);
                        radioButton5 = this.apa.aoK;
                        drawable = this.apa.aoZ;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.apa.aoL;
                        radioButton6.setChecked(false);
                        radioButton7 = this.apa.aoL;
                        drawable2 = this.apa.aoZ;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.apa.aoM;
                        radioButton8.setChecked(true);
                        radioButton9 = this.apa.aoM;
                        drawable3 = this.apa.aoY;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.apa.aoG;
            editText.setText(compoundButton.getText());
        }
    }
}
