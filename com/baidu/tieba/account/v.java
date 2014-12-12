package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class v implements TextWatcher {
    final /* synthetic */ Register2Activity ani;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Register2Activity register2Activity) {
        this.ani = register2Activity;
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
        editText = this.ani.amR;
        if (editable == editText.getEditableText()) {
            this.ani.bf(false);
        }
        editText2 = this.ani.amP;
        if (editText2.length() > 0) {
            editText7 = this.ani.amQ;
            if (editText7.length() >= 6) {
                editText8 = this.ani.amR;
                if (editText8.length() > 0) {
                    z = this.ani.amZ;
                    if (z) {
                        editText9 = this.ani.PE;
                        if (editText9.length() <= 0) {
                            relativeLayout3 = this.ani.amS;
                            relativeLayout3.setEnabled(false);
                            i = this.ani.anb;
                            i2 = Register2Activity.amB;
                            if (i == i2) {
                                editText6 = this.ani.amP;
                            }
                            i3 = this.ani.anb;
                            i4 = Register2Activity.amC;
                            if (i3 == i4) {
                                editText5 = this.ani.amQ;
                            }
                            i5 = this.ani.anb;
                            i6 = Register2Activity.amD;
                            if (i5 == i6) {
                                editText4 = this.ani.amR;
                            }
                            i7 = this.ani.anb;
                            i8 = Register2Activity.amE;
                            if (i7 == i8) {
                                editText3 = this.ani.PE;
                                if (editable != editText3.getEditableText()) {
                                    return;
                                }
                                this.ani.anb = -1;
                                this.ani.AE();
                                return;
                            }
                            return;
                        }
                    }
                    relativeLayout2 = this.ani.amS;
                    relativeLayout2.setEnabled(true);
                    i = this.ani.anb;
                    i2 = Register2Activity.amB;
                    if (i == i2) {
                    }
                    i3 = this.ani.anb;
                    i4 = Register2Activity.amC;
                    if (i3 == i4) {
                    }
                    i5 = this.ani.anb;
                    i6 = Register2Activity.amD;
                    if (i5 == i6) {
                    }
                    i7 = this.ani.anb;
                    i8 = Register2Activity.amE;
                    if (i7 == i8) {
                    }
                }
            }
        }
        relativeLayout = this.ani.amS;
        relativeLayout.setEnabled(false);
        i = this.ani.anb;
        i2 = Register2Activity.amB;
        if (i == i2) {
        }
        i3 = this.ani.anb;
        i4 = Register2Activity.amC;
        if (i3 == i4) {
        }
        i5 = this.ani.anb;
        i6 = Register2Activity.amD;
        if (i5 == i6) {
        }
        i7 = this.ani.anb;
        i8 = Register2Activity.amE;
        if (i7 == i8) {
        }
    }
}
