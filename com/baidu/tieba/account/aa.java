package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class aa implements TextWatcher {
    final /* synthetic */ Register2Activity aFh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(Register2Activity register2Activity) {
        this.aFh = register2Activity;
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
        editText = this.aFh.aEO;
        if (editable == editText.getEditableText()) {
            this.aFh.bv(false);
        }
        editText2 = this.aFh.aEM;
        if (editText2.length() > 0) {
            editText7 = this.aFh.aEN;
            if (editText7.length() >= 6) {
                editText8 = this.aFh.aEO;
                if (editText8.length() > 0) {
                    z = this.aFh.aEY;
                    if (z) {
                        editText9 = this.aFh.aEP;
                        if (editText9.length() <= 0) {
                            relativeLayout3 = this.aFh.aEQ;
                            relativeLayout3.setEnabled(false);
                            i = this.aFh.aFa;
                            if (i == Register2Activity.aEw) {
                                editText6 = this.aFh.aEM;
                            }
                            i2 = this.aFh.aFa;
                            i3 = Register2Activity.aEx;
                            if (i2 == i3) {
                                editText5 = this.aFh.aEN;
                            }
                            i4 = this.aFh.aFa;
                            i5 = Register2Activity.aEy;
                            if (i4 == i5) {
                                editText4 = this.aFh.aEO;
                            }
                            i6 = this.aFh.aFa;
                            if (i6 == Register2Activity.aEz) {
                                editText3 = this.aFh.aEP;
                                if (editable != editText3.getEditableText()) {
                                    return;
                                }
                                this.aFh.aFa = -1;
                                this.aFh.Ga();
                                return;
                            }
                            return;
                        }
                    }
                    relativeLayout2 = this.aFh.aEQ;
                    relativeLayout2.setEnabled(true);
                    i = this.aFh.aFa;
                    if (i == Register2Activity.aEw) {
                    }
                    i2 = this.aFh.aFa;
                    i3 = Register2Activity.aEx;
                    if (i2 == i3) {
                    }
                    i4 = this.aFh.aFa;
                    i5 = Register2Activity.aEy;
                    if (i4 == i5) {
                    }
                    i6 = this.aFh.aFa;
                    if (i6 == Register2Activity.aEz) {
                    }
                }
            }
        }
        relativeLayout = this.aFh.aEQ;
        relativeLayout.setEnabled(false);
        i = this.aFh.aFa;
        if (i == Register2Activity.aEw) {
        }
        i2 = this.aFh.aFa;
        i3 = Register2Activity.aEx;
        if (i2 == i3) {
        }
        i4 = this.aFh.aFa;
        i5 = Register2Activity.aEy;
        if (i4 == i5) {
        }
        i6 = this.aFh.aFa;
        if (i6 == Register2Activity.aEz) {
        }
    }
}
