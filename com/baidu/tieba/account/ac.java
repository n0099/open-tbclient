package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class ac implements TextWatcher {
    final /* synthetic */ Register2Activity awc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(Register2Activity register2Activity) {
        this.awc = register2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006a, code lost:
        if (r4 != r0.getEditableText()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0082, code lost:
        if (r4 != r0.getEditableText()) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
        if (r4 != r0.getEditableText()) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void afterTextChanged(Editable editable) {
        EditText editText;
        EditText editText2;
        RelativeLayout relativeLayout;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        EditText editText6;
        EditText editText7;
        EditText editText8;
        boolean z;
        RelativeLayout relativeLayout2;
        EditText editText9;
        RelativeLayout relativeLayout3;
        editText = this.awc.avJ;
        if (editable == editText.getEditableText()) {
            this.awc.bl(false);
        }
        editText2 = this.awc.avH;
        if (editText2.length() > 0) {
            editText7 = this.awc.avI;
            if (editText7.length() >= 6) {
                editText8 = this.awc.avJ;
                if (editText8.length() > 0) {
                    z = this.awc.avT;
                    if (z) {
                        editText9 = this.awc.avK;
                        if (editText9.length() <= 0) {
                            relativeLayout3 = this.awc.avL;
                            relativeLayout3.setEnabled(false);
                            i = this.awc.avV;
                            i2 = Register2Activity.avr;
                            if (i == i2) {
                                editText6 = this.awc.avH;
                            }
                            i3 = this.awc.avV;
                            i4 = Register2Activity.avs;
                            if (i3 == i4) {
                                editText5 = this.awc.avI;
                            }
                            i5 = this.awc.avV;
                            i6 = Register2Activity.avt;
                            if (i5 == i6) {
                                editText4 = this.awc.avJ;
                            }
                            i7 = this.awc.avV;
                            i8 = Register2Activity.avu;
                            if (i7 == i8) {
                                editText3 = this.awc.avK;
                                if (editable != editText3.getEditableText()) {
                                    return;
                                }
                                this.awc.avV = -1;
                                this.awc.Eo();
                                return;
                            }
                            return;
                        }
                    }
                    relativeLayout2 = this.awc.avL;
                    relativeLayout2.setEnabled(true);
                    i = this.awc.avV;
                    i2 = Register2Activity.avr;
                    if (i == i2) {
                    }
                    i3 = this.awc.avV;
                    i4 = Register2Activity.avs;
                    if (i3 == i4) {
                    }
                    i5 = this.awc.avV;
                    i6 = Register2Activity.avt;
                    if (i5 == i6) {
                    }
                    i7 = this.awc.avV;
                    i8 = Register2Activity.avu;
                    if (i7 == i8) {
                    }
                }
            }
        }
        relativeLayout = this.awc.avL;
        relativeLayout.setEnabled(false);
        i = this.awc.avV;
        i2 = Register2Activity.avr;
        if (i == i2) {
        }
        i3 = this.awc.avV;
        i4 = Register2Activity.avs;
        if (i3 == i4) {
        }
        i5 = this.awc.avV;
        i6 = Register2Activity.avt;
        if (i5 == i6) {
        }
        i7 = this.awc.avV;
        i8 = Register2Activity.avu;
        if (i7 == i8) {
        }
    }
}
