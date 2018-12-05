package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a bsp = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.bsp.context = context;
        this.bsp.bsq = eVar;
    }

    public a b(boolean[] zArr) {
        this.bsp.bsx = zArr;
        return this;
    }

    public a gZ(int i) {
        this.bsp.bsX = i;
        return this;
    }

    public a ha(int i) {
        this.bsp.btb = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.bsp.bsy = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.bsp.bsP = i;
        this.bsp.bss = aVar;
        return this;
    }

    public a ae(float f) {
        this.bsp.btf = f;
        return this;
    }

    public a hb(int i) {
        this.bsp.bte = i;
        return this;
    }

    public a hc(int i) {
        this.bsp.bdL = i;
        return this;
    }

    public a hd(int i) {
        this.bsp.btd = i;
        return this;
    }

    public a he(int i) {
        this.bsp.btc = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.bsp.bsD = str;
        this.bsp.bsE = str2;
        this.bsp.bsF = str3;
        this.bsp.bsG = str4;
        this.bsp.bsH = str5;
        this.bsp.bsI = str6;
        return this;
    }

    public a e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bsp.bsJ = i;
        this.bsp.bsK = i2;
        this.bsp.bsL = i3;
        this.bsp.bsM = i4;
        this.bsp.bsN = i5;
        this.bsp.bsO = i6;
        return this;
    }

    public a dc(boolean z) {
        this.bsp.bti = z;
        return this;
    }

    public b SX() {
        return new b(this.bsp);
    }
}
