package com.baidu.tieba.im.e;

import android.text.InputFilter;
import android.text.Spanned;
/* loaded from: classes.dex */
public class a implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private int f1689a;

    public a(int i) {
        this.f1689a = i;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5 = i4 - i3;
        int length = this.f1689a - (spanned.length() - i5);
        String obj = spanned.toString();
        int a2 = g.a(obj);
        if (i5 > 0) {
            int i6 = i3;
            while (i6 < i5 + i3 && obj.length() < i6) {
                int a3 = a2 - g.a(obj.charAt(i6));
                i6++;
                a2 = a3;
            }
        } else {
            a2 += g.a(charSequence.toString());
        }
        if (a2 > this.f1689a || length <= 0) {
            return "";
        }
        if (length >= i2 - i) {
            return null;
        }
        return charSequence.subSequence(i, i + length);
    }
}
