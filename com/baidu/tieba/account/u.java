package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class u implements TextWatcher {
    final /* synthetic */ Register2Activity afJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(Register2Activity register2Activity) {
        this.afJ = register2Activity;
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
        editText = this.afJ.afs;
        if (editable == editText.getEditableText()) {
            this.afJ.bg(false);
        }
        editText2 = this.afJ.afq;
        if (editText2.length() > 0) {
            editText7 = this.afJ.afr;
            if (editText7.length() >= 6) {
                editText8 = this.afJ.afs;
                if (editText8.length() > 0) {
                    z = this.afJ.afA;
                    if (z) {
                        editText9 = this.afJ.Ku;
                        if (editText9.length() <= 0) {
                            relativeLayout3 = this.afJ.aft;
                            relativeLayout3.setEnabled(false);
                            i = this.afJ.afC;
                            i2 = Register2Activity.afc;
                            if (i == i2) {
                                editText6 = this.afJ.afq;
                            }
                            i3 = this.afJ.afC;
                            i4 = Register2Activity.afd;
                            if (i3 == i4) {
                                editText5 = this.afJ.afr;
                            }
                            i5 = this.afJ.afC;
                            i6 = Register2Activity.afe;
                            if (i5 == i6) {
                                editText4 = this.afJ.afs;
                            }
                            i7 = this.afJ.afC;
                            i8 = Register2Activity.aff;
                            if (i7 == i8) {
                                editText3 = this.afJ.Ku;
                                if (editable != editText3.getEditableText()) {
                                    return;
                                }
                                this.afJ.afC = -1;
                                this.afJ.xj();
                                return;
                            }
                            return;
                        }
                    }
                    relativeLayout2 = this.afJ.aft;
                    relativeLayout2.setEnabled(true);
                    i = this.afJ.afC;
                    i2 = Register2Activity.afc;
                    if (i == i2) {
                    }
                    i3 = this.afJ.afC;
                    i4 = Register2Activity.afd;
                    if (i3 == i4) {
                    }
                    i5 = this.afJ.afC;
                    i6 = Register2Activity.afe;
                    if (i5 == i6) {
                    }
                    i7 = this.afJ.afC;
                    i8 = Register2Activity.aff;
                    if (i7 == i8) {
                    }
                }
            }
        }
        relativeLayout = this.afJ.aft;
        relativeLayout.setEnabled(false);
        i = this.afJ.afC;
        i2 = Register2Activity.afc;
        if (i == i2) {
        }
        i3 = this.afJ.afC;
        i4 = Register2Activity.afd;
        if (i3 == i4) {
        }
        i5 = this.afJ.afC;
        i6 = Register2Activity.afe;
        if (i5 == i6) {
        }
        i7 = this.afJ.afC;
        i8 = Register2Activity.aff;
        if (i7 == i8) {
        }
    }
}
