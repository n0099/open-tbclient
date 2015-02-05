package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class w implements TextWatcher {
    final /* synthetic */ Register2Activity aoa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(Register2Activity register2Activity) {
        this.aoa = register2Activity;
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
        editText = this.aoa.anJ;
        if (editable == editText.getEditableText()) {
            this.aoa.bh(false);
        }
        editText2 = this.aoa.anH;
        if (editText2.length() > 0) {
            editText7 = this.aoa.anI;
            if (editText7.length() >= 6) {
                editText8 = this.aoa.anJ;
                if (editText8.length() > 0) {
                    z = this.aoa.anR;
                    if (z) {
                        editText9 = this.aoa.Qd;
                        if (editText9.length() <= 0) {
                            relativeLayout3 = this.aoa.anK;
                            relativeLayout3.setEnabled(false);
                            i = this.aoa.anT;
                            i2 = Register2Activity.ant;
                            if (i == i2) {
                                editText6 = this.aoa.anH;
                            }
                            i3 = this.aoa.anT;
                            i4 = Register2Activity.anu;
                            if (i3 == i4) {
                                editText5 = this.aoa.anI;
                            }
                            i5 = this.aoa.anT;
                            i6 = Register2Activity.anv;
                            if (i5 == i6) {
                                editText4 = this.aoa.anJ;
                            }
                            i7 = this.aoa.anT;
                            i8 = Register2Activity.anw;
                            if (i7 == i8) {
                                editText3 = this.aoa.Qd;
                                if (editable != editText3.getEditableText()) {
                                    return;
                                }
                                this.aoa.anT = -1;
                                this.aoa.AY();
                                return;
                            }
                            return;
                        }
                    }
                    relativeLayout2 = this.aoa.anK;
                    relativeLayout2.setEnabled(true);
                    i = this.aoa.anT;
                    i2 = Register2Activity.ant;
                    if (i == i2) {
                    }
                    i3 = this.aoa.anT;
                    i4 = Register2Activity.anu;
                    if (i3 == i4) {
                    }
                    i5 = this.aoa.anT;
                    i6 = Register2Activity.anv;
                    if (i5 == i6) {
                    }
                    i7 = this.aoa.anT;
                    i8 = Register2Activity.anw;
                    if (i7 == i8) {
                    }
                }
            }
        }
        relativeLayout = this.aoa.anK;
        relativeLayout.setEnabled(false);
        i = this.aoa.anT;
        i2 = Register2Activity.ant;
        if (i == i2) {
        }
        i3 = this.aoa.anT;
        i4 = Register2Activity.anu;
        if (i3 == i4) {
        }
        i5 = this.aoa.anT;
        i6 = Register2Activity.anv;
        if (i5 == i6) {
        }
        i7 = this.aoa.anT;
        i8 = Register2Activity.anw;
        if (i7 == i8) {
        }
    }
}
