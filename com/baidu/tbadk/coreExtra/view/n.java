package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ k akC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.akC = kVar;
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
            radioButton = this.akC.akm;
            if (compoundButton == radioButton) {
                radioGroup3 = this.akC.akk;
                radioGroup3.clearCheck();
                radioButton16 = this.akC.akm;
                radioButton16.setChecked(true);
                radioButton17 = this.akC.akm;
                drawable7 = this.akC.akA;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.akC.akn;
                radioButton18.setChecked(false);
                radioButton19 = this.akC.akn;
                drawable8 = this.akC.akB;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.akC.ako;
                radioButton20.setChecked(false);
                radioButton21 = this.akC.ako;
                drawable9 = this.akC.akB;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.akC.akn;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.akC.akk;
                    radioGroup2.clearCheck();
                    radioButton10 = this.akC.akm;
                    radioButton10.setChecked(false);
                    radioButton11 = this.akC.akm;
                    drawable4 = this.akC.akB;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.akC.akn;
                    radioButton12.setChecked(true);
                    radioButton13 = this.akC.akn;
                    drawable5 = this.akC.akA;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.akC.ako;
                    radioButton14.setChecked(false);
                    radioButton15 = this.akC.ako;
                    drawable6 = this.akC.akB;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.akC.ako;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.akC.akj;
                        radioGroup.clearCheck();
                        radioButton4 = this.akC.akm;
                        radioButton4.setChecked(false);
                        radioButton5 = this.akC.akm;
                        drawable = this.akC.akB;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.akC.akn;
                        radioButton6.setChecked(false);
                        radioButton7 = this.akC.akn;
                        drawable2 = this.akC.akB;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.akC.ako;
                        radioButton8.setChecked(true);
                        radioButton9 = this.akC.ako;
                        drawable3 = this.akC.akA;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.akC.aki;
            editText.setText(compoundButton.getText());
        }
    }
}
