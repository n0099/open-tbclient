package com.baidu.tieba.account;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.RelativeLayout;
/* loaded from: classes.dex */
class au implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Register2Activity f1033a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(Register2Activity register2Activity) {
        this.f1033a = register2Activity;
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
        editText = this.f1033a.z;
        if (editable == editText.getEditableText()) {
            this.f1033a.a(false);
        }
        editText2 = this.f1033a.x;
        if (editText2.length() > 0) {
            editText7 = this.f1033a.y;
            if (editText7.length() >= 6) {
                editText8 = this.f1033a.z;
                if (editText8.length() > 0) {
                    z = this.f1033a.M;
                    if (z) {
                        editText9 = this.f1033a.A;
                        if (editText9.length() <= 0) {
                            relativeLayout3 = this.f1033a.B;
                            relativeLayout3.setEnabled(false);
                            i = this.f1033a.O;
                            i2 = Register2Activity.f;
                            if (i == i2) {
                                editText6 = this.f1033a.x;
                            }
                            i3 = this.f1033a.O;
                            i4 = Register2Activity.g;
                            if (i3 == i4) {
                                editText5 = this.f1033a.y;
                            }
                            i5 = this.f1033a.O;
                            i6 = Register2Activity.j;
                            if (i5 == i6) {
                                editText4 = this.f1033a.z;
                            }
                            i7 = this.f1033a.O;
                            i8 = Register2Activity.k;
                            if (i7 == i8) {
                                editText3 = this.f1033a.A;
                                if (editable != editText3.getEditableText()) {
                                    return;
                                }
                                this.f1033a.O = -1;
                                this.f1033a.s();
                                return;
                            }
                            return;
                        }
                    }
                    relativeLayout2 = this.f1033a.B;
                    relativeLayout2.setEnabled(true);
                    i = this.f1033a.O;
                    i2 = Register2Activity.f;
                    if (i == i2) {
                    }
                    i3 = this.f1033a.O;
                    i4 = Register2Activity.g;
                    if (i3 == i4) {
                    }
                    i5 = this.f1033a.O;
                    i6 = Register2Activity.j;
                    if (i5 == i6) {
                    }
                    i7 = this.f1033a.O;
                    i8 = Register2Activity.k;
                    if (i7 == i8) {
                    }
                }
            }
        }
        relativeLayout = this.f1033a.B;
        relativeLayout.setEnabled(false);
        i = this.f1033a.O;
        i2 = Register2Activity.f;
        if (i == i2) {
        }
        i3 = this.f1033a.O;
        i4 = Register2Activity.g;
        if (i3 == i4) {
        }
        i5 = this.f1033a.O;
        i6 = Register2Activity.j;
        if (i5 == i6) {
        }
        i7 = this.f1033a.O;
        i8 = Register2Activity.k;
        if (i7 == i8) {
        }
    }
}
