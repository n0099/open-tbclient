package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class ah implements TextWatcher {
    final /* synthetic */ Register2Activity axP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(Register2Activity register2Activity) {
        this.axP = register2Activity;
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
        editText = this.axP.axw;
        if (editable == editText.getEditableText()) {
            this.axP.bu(false);
        }
        editText2 = this.axP.axu;
        if (editText2.length() > 0) {
            editText7 = this.axP.axv;
            if (editText7.length() >= 6) {
                editText8 = this.axP.axw;
                if (editText8.length() > 0) {
                    z = this.axP.axG;
                    if (z) {
                        editText9 = this.axP.axx;
                        if (editText9.length() <= 0) {
                            relativeLayout3 = this.axP.axy;
                            relativeLayout3.setEnabled(false);
                            i = this.axP.axI;
                            i2 = Register2Activity.axe;
                            if (i == i2) {
                                editText6 = this.axP.axu;
                            }
                            i3 = this.axP.axI;
                            i4 = Register2Activity.axf;
                            if (i3 == i4) {
                                editText5 = this.axP.axv;
                            }
                            i5 = this.axP.axI;
                            i6 = Register2Activity.axg;
                            if (i5 == i6) {
                                editText4 = this.axP.axw;
                            }
                            i7 = this.axP.axI;
                            i8 = Register2Activity.axh;
                            if (i7 == i8) {
                                editText3 = this.axP.axx;
                                if (editable != editText3.getEditableText()) {
                                    return;
                                }
                                this.axP.axI = -1;
                                this.axP.Fl();
                                return;
                            }
                            return;
                        }
                    }
                    relativeLayout2 = this.axP.axy;
                    relativeLayout2.setEnabled(true);
                    i = this.axP.axI;
                    i2 = Register2Activity.axe;
                    if (i == i2) {
                    }
                    i3 = this.axP.axI;
                    i4 = Register2Activity.axf;
                    if (i3 == i4) {
                    }
                    i5 = this.axP.axI;
                    i6 = Register2Activity.axg;
                    if (i5 == i6) {
                    }
                    i7 = this.axP.axI;
                    i8 = Register2Activity.axh;
                    if (i7 == i8) {
                    }
                }
            }
        }
        relativeLayout = this.axP.axy;
        relativeLayout.setEnabled(false);
        i = this.axP.axI;
        i2 = Register2Activity.axe;
        if (i == i2) {
        }
        i3 = this.axP.axI;
        i4 = Register2Activity.axf;
        if (i3 == i4) {
        }
        i5 = this.axP.axI;
        i6 = Register2Activity.axg;
        if (i5 == i6) {
        }
        i7 = this.axP.axI;
        i8 = Register2Activity.axh;
        if (i7 == i8) {
        }
    }
}
