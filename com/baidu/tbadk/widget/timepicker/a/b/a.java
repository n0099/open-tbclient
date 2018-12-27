package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a bss = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.bss.context = context;
        this.bss.bst = eVar;
    }

    public a b(boolean[] zArr) {
        this.bss.bsA = zArr;
        return this;
    }

    public a ha(int i) {
        this.bss.bta = i;
        return this;
    }

    public a hb(int i) {
        this.bss.bte = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.bss.bsB = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.bss.bsS = i;
        this.bss.bsv = aVar;
        return this;
    }

    public a ae(float f) {
        this.bss.bti = f;
        return this;
    }

    public a hc(int i) {
        this.bss.bth = i;
        return this;
    }

    public a hd(int i) {
        this.bss.bdO = i;
        return this;
    }

    public a he(int i) {
        this.bss.btg = i;
        return this;
    }

    public a hf(int i) {
        this.bss.btf = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.bss.bsG = str;
        this.bss.bsH = str2;
        this.bss.bsI = str3;
        this.bss.bsJ = str4;
        this.bss.bsK = str5;
        this.bss.bsL = str6;
        return this;
    }

    public a e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bss.bsM = i;
        this.bss.bsN = i2;
        this.bss.bsO = i3;
        this.bss.bsP = i4;
        this.bss.bsQ = i5;
        this.bss.bsR = i6;
        return this;
    }

    public a dc(boolean z) {
        this.bss.btl = z;
        return this;
    }

    public b SZ() {
        return new b(this.bss);
    }
}
