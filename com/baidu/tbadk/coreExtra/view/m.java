package com.baidu.tbadk.coreExtra.view;

import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements CompoundButton.OnCheckedChangeListener {
    final /* synthetic */ j aot;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(j jVar) {
        this.aot = jVar;
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
            radioButton = this.aot.aod;
            if (compoundButton == radioButton) {
                radioGroup3 = this.aot.aob;
                radioGroup3.clearCheck();
                radioButton16 = this.aot.aod;
                radioButton16.setChecked(true);
                radioButton17 = this.aot.aod;
                drawable7 = this.aot.aor;
                radioButton17.setCompoundDrawables(drawable7, null, null, null);
                radioButton18 = this.aot.aoe;
                radioButton18.setChecked(false);
                radioButton19 = this.aot.aoe;
                drawable8 = this.aot.aos;
                radioButton19.setCompoundDrawables(drawable8, null, null, null);
                radioButton20 = this.aot.aof;
                radioButton20.setChecked(false);
                radioButton21 = this.aot.aof;
                drawable9 = this.aot.aos;
                radioButton21.setCompoundDrawables(drawable9, null, null, null);
            } else {
                radioButton2 = this.aot.aoe;
                if (compoundButton == radioButton2) {
                    radioGroup2 = this.aot.aob;
                    radioGroup2.clearCheck();
                    radioButton10 = this.aot.aod;
                    radioButton10.setChecked(false);
                    radioButton11 = this.aot.aod;
                    drawable4 = this.aot.aos;
                    radioButton11.setCompoundDrawables(drawable4, null, null, null);
                    radioButton12 = this.aot.aoe;
                    radioButton12.setChecked(true);
                    radioButton13 = this.aot.aoe;
                    drawable5 = this.aot.aor;
                    radioButton13.setCompoundDrawables(drawable5, null, null, null);
                    radioButton14 = this.aot.aof;
                    radioButton14.setChecked(false);
                    radioButton15 = this.aot.aof;
                    drawable6 = this.aot.aos;
                    radioButton15.setCompoundDrawables(drawable6, null, null, null);
                } else {
                    radioButton3 = this.aot.aof;
                    if (compoundButton == radioButton3) {
                        radioGroup = this.aot.aoa;
                        radioGroup.clearCheck();
                        radioButton4 = this.aot.aod;
                        radioButton4.setChecked(false);
                        radioButton5 = this.aot.aod;
                        drawable = this.aot.aos;
                        radioButton5.setCompoundDrawables(drawable, null, null, null);
                        radioButton6 = this.aot.aoe;
                        radioButton6.setChecked(false);
                        radioButton7 = this.aot.aoe;
                        drawable2 = this.aot.aos;
                        radioButton7.setCompoundDrawables(drawable2, null, null, null);
                        radioButton8 = this.aot.aof;
                        radioButton8.setChecked(true);
                        radioButton9 = this.aot.aof;
                        drawable3 = this.aot.aor;
                        radioButton9.setCompoundDrawables(drawable3, null, null, null);
                    }
                }
            }
            editText = this.aot.anZ;
            editText.setText(compoundButton.getText());
        }
    }
}
