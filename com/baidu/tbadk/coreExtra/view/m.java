package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j aky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.aky = jVar;
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
            radioButton = this.aky.aki;
            if (compoundButton == radioButton) {
                radioGroup3 = this.aky.akg;
                radioGroup3.clearCheck();
                radioButton16 = this.aky.aki;
                radioButton16.setChecked(true);
                radioButton17 = this.aky.aki;
                drawable7 = this.aky.akw;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.aky.akj;
                radioButton18.setChecked(false);
                radioButton19 = this.aky.akj;
                drawable8 = this.aky.akx;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.aky.akk;
                radioButton20.setChecked(false);
                radioButton21 = this.aky.akk;
                drawable9 = this.aky.akx;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.aky.akj;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.aky.akg;
                    radioGroup2.clearCheck();
                    radioButton10 = this.aky.aki;
                    radioButton10.setChecked(false);
                    radioButton11 = this.aky.aki;
                    drawable4 = this.aky.akx;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.aky.akj;
                    radioButton12.setChecked(true);
                    radioButton13 = this.aky.akj;
                    drawable5 = this.aky.akw;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.aky.akk;
                    radioButton14.setChecked(false);
                    radioButton15 = this.aky.akk;
                    drawable6 = this.aky.akx;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.aky.akk;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.aky.akf;
                        radioGroup.clearCheck();
                        radioButton4 = this.aky.aki;
                        radioButton4.setChecked(false);
                        radioButton5 = this.aky.aki;
                        drawable = this.aky.akx;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.aky.akj;
                        radioButton6.setChecked(false);
                        radioButton7 = this.aky.akj;
                        drawable2 = this.aky.akx;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.aky.akk;
                        radioButton8.setChecked(true);
                        radioButton9 = this.aky.akk;
                        drawable3 = this.aky.akw;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.aky.ake;
            editText.setText(compoundButton.getText());
        }
    }
}
