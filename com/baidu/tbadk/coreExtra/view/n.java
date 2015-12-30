package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ k anA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.anA = kVar;
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
            radioButton = this.anA.ank;
            if (compoundButton == radioButton) {
                radioGroup3 = this.anA.ani;
                radioGroup3.clearCheck();
                radioButton16 = this.anA.ank;
                radioButton16.setChecked(true);
                radioButton17 = this.anA.ank;
                drawable7 = this.anA.any;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.anA.anl;
                radioButton18.setChecked(false);
                radioButton19 = this.anA.anl;
                drawable8 = this.anA.anz;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.anA.anm;
                radioButton20.setChecked(false);
                radioButton21 = this.anA.anm;
                drawable9 = this.anA.anz;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.anA.anl;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.anA.ani;
                    radioGroup2.clearCheck();
                    radioButton10 = this.anA.ank;
                    radioButton10.setChecked(false);
                    radioButton11 = this.anA.ank;
                    drawable4 = this.anA.anz;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.anA.anl;
                    radioButton12.setChecked(true);
                    radioButton13 = this.anA.anl;
                    drawable5 = this.anA.any;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.anA.anm;
                    radioButton14.setChecked(false);
                    radioButton15 = this.anA.anm;
                    drawable6 = this.anA.anz;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.anA.anm;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.anA.anh;
                        radioGroup.clearCheck();
                        radioButton4 = this.anA.ank;
                        radioButton4.setChecked(false);
                        radioButton5 = this.anA.ank;
                        drawable = this.anA.anz;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.anA.anl;
                        radioButton6.setChecked(false);
                        radioButton7 = this.anA.anl;
                        drawable2 = this.anA.anz;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.anA.anm;
                        radioButton8.setChecked(true);
                        radioButton9 = this.anA.anm;
                        drawable3 = this.anA.any;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.anA.ang;
            editText.setText(compoundButton.getText());
        }
    }
}
