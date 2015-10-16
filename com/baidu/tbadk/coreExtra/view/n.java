package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ k akD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.akD = kVar;
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
            radioButton = this.akD.akn;
            if (compoundButton == radioButton) {
                radioGroup3 = this.akD.akl;
                radioGroup3.clearCheck();
                radioButton16 = this.akD.akn;
                radioButton16.setChecked(true);
                radioButton17 = this.akD.akn;
                drawable7 = this.akD.akB;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.akD.ako;
                radioButton18.setChecked(false);
                radioButton19 = this.akD.ako;
                drawable8 = this.akD.akC;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.akD.akp;
                radioButton20.setChecked(false);
                radioButton21 = this.akD.akp;
                drawable9 = this.akD.akC;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.akD.ako;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.akD.akl;
                    radioGroup2.clearCheck();
                    radioButton10 = this.akD.akn;
                    radioButton10.setChecked(false);
                    radioButton11 = this.akD.akn;
                    drawable4 = this.akD.akC;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.akD.ako;
                    radioButton12.setChecked(true);
                    radioButton13 = this.akD.ako;
                    drawable5 = this.akD.akB;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.akD.akp;
                    radioButton14.setChecked(false);
                    radioButton15 = this.akD.akp;
                    drawable6 = this.akD.akC;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.akD.akp;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.akD.akk;
                        radioGroup.clearCheck();
                        radioButton4 = this.akD.akn;
                        radioButton4.setChecked(false);
                        radioButton5 = this.akD.akn;
                        drawable = this.akD.akC;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.akD.ako;
                        radioButton6.setChecked(false);
                        radioButton7 = this.akD.ako;
                        drawable2 = this.akD.akC;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.akD.akp;
                        radioButton8.setChecked(true);
                        radioButton9 = this.akD.akp;
                        drawable3 = this.akD.akB;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.akD.akj;
            editText.setText(compoundButton.getText());
        }
    }
}
