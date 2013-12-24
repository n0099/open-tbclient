package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class bm implements TextWatcher {
    final /* synthetic */ Register2Activity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(Register2Activity register2Activity) {
        this.a = register2Activity;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
        if (r5 != r0.getEditableText()) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:
        if (r5 != r0.getEditableText()) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009b, code lost:
        if (r5 != r0.getEditableText()) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a9  */
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
        editText = this.a.v;
        if (editable == editText.getEditableText()) {
            this.a.a(false);
        }
        editText2 = this.a.t;
        if (editText2.length() > 0) {
            editText7 = this.a.u;
            if (editText7.length() >= 6) {
                editText8 = this.a.v;
                if (editText8.length() > 0) {
                    z = this.a.I;
                    if (z) {
                        editText9 = this.a.w;
                        if (editText9.length() <= 0) {
                            relativeLayout3 = this.a.x;
                            relativeLayout3.setEnabled(false);
                            i = this.a.K;
                            i2 = Register2Activity.d;
                            if (i == i2) {
                                editText6 = this.a.t;
                            }
                            i3 = this.a.K;
                            i4 = Register2Activity.e;
                            if (i3 == i4) {
                                editText5 = this.a.u;
                            }
                            i5 = this.a.K;
                            i6 = Register2Activity.f;
                            if (i5 == i6) {
                                editText4 = this.a.v;
                            }
                            i7 = this.a.K;
                            i8 = Register2Activity.g;
                            if (i7 == i8) {
                                editText3 = this.a.w;
                                if (editable != editText3.getEditableText()) {
                                    return;
                                }
                                this.a.K = -1;
                                this.a.k();
                                return;
                            }
                            return;
                        }
                    }
                    relativeLayout2 = this.a.x;
                    relativeLayout2.setEnabled(true);
                    i = this.a.K;
                    i2 = Register2Activity.d;
                    if (i == i2) {
                    }
                    i3 = this.a.K;
                    i4 = Register2Activity.e;
                    if (i3 == i4) {
                    }
                    i5 = this.a.K;
                    i6 = Register2Activity.f;
                    if (i5 == i6) {
                    }
                    i7 = this.a.K;
                    i8 = Register2Activity.g;
                    if (i7 == i8) {
                    }
                }
            }
        }
        relativeLayout = this.a.x;
        relativeLayout.setEnabled(false);
        i = this.a.K;
        i2 = Register2Activity.d;
        if (i == i2) {
        }
        i3 = this.a.K;
        i4 = Register2Activity.e;
        if (i3 == i4) {
        }
        i5 = this.a.K;
        i6 = Register2Activity.f;
        if (i5 == i6) {
        }
        i7 = this.a.K;
        i8 = Register2Activity.g;
        if (i7 == i8) {
        }
    }
}
