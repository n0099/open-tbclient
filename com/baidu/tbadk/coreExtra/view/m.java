package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j atX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.atX = jVar;
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
            radioButton = this.atX.atH;
            if (compoundButton == radioButton) {
                radioGroup3 = this.atX.atF;
                radioGroup3.clearCheck();
                radioButton16 = this.atX.atH;
                radioButton16.setChecked(true);
                radioButton17 = this.atX.atH;
                drawable7 = this.atX.atV;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.atX.atI;
                radioButton18.setChecked(false);
                radioButton19 = this.atX.atI;
                drawable8 = this.atX.atW;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.atX.atJ;
                radioButton20.setChecked(false);
                radioButton21 = this.atX.atJ;
                drawable9 = this.atX.atW;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.atX.atI;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.atX.atF;
                    radioGroup2.clearCheck();
                    radioButton10 = this.atX.atH;
                    radioButton10.setChecked(false);
                    radioButton11 = this.atX.atH;
                    drawable4 = this.atX.atW;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.atX.atI;
                    radioButton12.setChecked(true);
                    radioButton13 = this.atX.atI;
                    drawable5 = this.atX.atV;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.atX.atJ;
                    radioButton14.setChecked(false);
                    radioButton15 = this.atX.atJ;
                    drawable6 = this.atX.atW;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.atX.atJ;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.atX.atE;
                        radioGroup.clearCheck();
                        radioButton4 = this.atX.atH;
                        radioButton4.setChecked(false);
                        radioButton5 = this.atX.atH;
                        drawable = this.atX.atW;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.atX.atI;
                        radioButton6.setChecked(false);
                        radioButton7 = this.atX.atI;
                        drawable2 = this.atX.atW;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.atX.atJ;
                        radioButton8.setChecked(true);
                        radioButton9 = this.atX.atJ;
                        drawable3 = this.atX.atV;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.atX.atD;
            editText.setText(compoundButton.getText());
        }
    }
}
