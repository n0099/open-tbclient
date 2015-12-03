package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ k amt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k kVar) {
        this.amt = kVar;
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
            radioButton = this.amt.amd;
            if (compoundButton == radioButton) {
                radioGroup3 = this.amt.amb;
                radioGroup3.clearCheck();
                radioButton16 = this.amt.amd;
                radioButton16.setChecked(true);
                radioButton17 = this.amt.amd;
                drawable7 = this.amt.amr;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.amt.ame;
                radioButton18.setChecked(false);
                radioButton19 = this.amt.ame;
                drawable8 = this.amt.ams;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.amt.amf;
                radioButton20.setChecked(false);
                radioButton21 = this.amt.amf;
                drawable9 = this.amt.ams;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.amt.ame;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.amt.amb;
                    radioGroup2.clearCheck();
                    radioButton10 = this.amt.amd;
                    radioButton10.setChecked(false);
                    radioButton11 = this.amt.amd;
                    drawable4 = this.amt.ams;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.amt.ame;
                    radioButton12.setChecked(true);
                    radioButton13 = this.amt.ame;
                    drawable5 = this.amt.amr;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.amt.amf;
                    radioButton14.setChecked(false);
                    radioButton15 = this.amt.amf;
                    drawable6 = this.amt.ams;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.amt.amf;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.amt.ama;
                        radioGroup.clearCheck();
                        radioButton4 = this.amt.amd;
                        radioButton4.setChecked(false);
                        radioButton5 = this.amt.amd;
                        drawable = this.amt.ams;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.amt.ame;
                        radioButton6.setChecked(false);
                        radioButton7 = this.amt.ame;
                        drawable2 = this.amt.ams;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.amt.amf;
                        radioButton8.setChecked(true);
                        radioButton9 = this.amt.amf;
                        drawable3 = this.amt.amr;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.amt.alZ;
            editText.setText(compoundButton.getText());
        }
    }
}
