package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class w implements TextWatcher {
    final /* synthetic */ Register2Activity aod;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Register2Activity register2Activity) {
        this.aod = register2Activity;
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
        editText = this.aod.anM;
        if (editable == editText.getEditableText()) {
            this.aod.bh(false);
        }
        editText2 = this.aod.anK;
        if (editText2.length() > 0) {
            editText7 = this.aod.anL;
            if (editText7.length() >= 6) {
                editText8 = this.aod.anM;
                if (editText8.length() > 0) {
                    z = this.aod.anU;
                    if (z) {
                        editText9 = this.aod.Qg;
                        if (editText9.length() <= 0) {
                            relativeLayout3 = this.aod.anN;
                            relativeLayout3.setEnabled(false);
                            i = this.aod.anW;
                            i2 = Register2Activity.anw;
                            if (i == i2) {
                                editText6 = this.aod.anK;
                            }
                            i3 = this.aod.anW;
                            i4 = Register2Activity.anx;
                            if (i3 == i4) {
                                editText5 = this.aod.anL;
                            }
                            i5 = this.aod.anW;
                            i6 = Register2Activity.any;
                            if (i5 == i6) {
                                editText4 = this.aod.anM;
                            }
                            i7 = this.aod.anW;
                            i8 = Register2Activity.anz;
                            if (i7 == i8) {
                                editText3 = this.aod.Qg;
                                if (editable != editText3.getEditableText()) {
                                    return;
                                }
                                this.aod.anW = -1;
                                this.aod.Be();
                                return;
                            }
                            return;
                        }
                    }
                    relativeLayout2 = this.aod.anN;
                    relativeLayout2.setEnabled(true);
                    i = this.aod.anW;
                    i2 = Register2Activity.anw;
                    if (i == i2) {
                    }
                    i3 = this.aod.anW;
                    i4 = Register2Activity.anx;
                    if (i3 == i4) {
                    }
                    i5 = this.aod.anW;
                    i6 = Register2Activity.any;
                    if (i5 == i6) {
                    }
                    i7 = this.aod.anW;
                    i8 = Register2Activity.anz;
                    if (i7 == i8) {
                    }
                }
            }
        }
        relativeLayout = this.aod.anN;
        relativeLayout.setEnabled(false);
        i = this.aod.anW;
        i2 = Register2Activity.anw;
        if (i == i2) {
        }
        i3 = this.aod.anW;
        i4 = Register2Activity.anx;
        if (i3 == i4) {
        }
        i5 = this.aod.anW;
        i6 = Register2Activity.any;
        if (i5 == i6) {
        }
        i7 = this.aod.anW;
        i8 = Register2Activity.anz;
        if (i7 == i8) {
        }
    }
}
