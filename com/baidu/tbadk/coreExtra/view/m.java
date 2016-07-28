package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j alU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.alU = jVar;
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
            radioButton = this.alU.alE;
            if (compoundButton == radioButton) {
                radioGroup3 = this.alU.alC;
                radioGroup3.clearCheck();
                radioButton16 = this.alU.alE;
                radioButton16.setChecked(true);
                radioButton17 = this.alU.alE;
                drawable7 = this.alU.alS;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.alU.alF;
                radioButton18.setChecked(false);
                radioButton19 = this.alU.alF;
                drawable8 = this.alU.alT;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.alU.alG;
                radioButton20.setChecked(false);
                radioButton21 = this.alU.alG;
                drawable9 = this.alU.alT;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.alU.alF;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.alU.alC;
                    radioGroup2.clearCheck();
                    radioButton10 = this.alU.alE;
                    radioButton10.setChecked(false);
                    radioButton11 = this.alU.alE;
                    drawable4 = this.alU.alT;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.alU.alF;
                    radioButton12.setChecked(true);
                    radioButton13 = this.alU.alF;
                    drawable5 = this.alU.alS;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.alU.alG;
                    radioButton14.setChecked(false);
                    radioButton15 = this.alU.alG;
                    drawable6 = this.alU.alT;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.alU.alG;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.alU.alB;
                        radioGroup.clearCheck();
                        radioButton4 = this.alU.alE;
                        radioButton4.setChecked(false);
                        radioButton5 = this.alU.alE;
                        drawable = this.alU.alT;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.alU.alF;
                        radioButton6.setChecked(false);
                        radioButton7 = this.alU.alF;
                        drawable2 = this.alU.alT;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.alU.alG;
                        radioButton8.setChecked(true);
                        radioButton9 = this.alU.alG;
                        drawable3 = this.alU.alS;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.alU.alA;
            editText.setText(compoundButton.getText());
        }
    }
}
