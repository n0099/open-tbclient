package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a cMC = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.cMC.context = context;
        this.cMC.cMD = eVar;
    }

    public a b(boolean[] zArr) {
        this.cMC.cMK = zArr;
        return this;
    }

    public a lE(int i) {
        this.cMC.cNk = i;
        return this;
    }

    public a lF(int i) {
        this.cMC.cNo = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.cMC.cML = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.cMC.cNc = i;
        this.cMC.cMF = aVar;
        return this;
    }

    public a av(float f) {
        this.cMC.cNs = f;
        return this;
    }

    public a lG(int i) {
        this.cMC.cNr = i;
        return this;
    }

    public a lH(int i) {
        this.cMC.cwo = i;
        return this;
    }

    public a lI(int i) {
        this.cMC.cNq = i;
        return this;
    }

    public a lJ(int i) {
        this.cMC.cNp = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cMC.cMQ = str;
        this.cMC.cMR = str2;
        this.cMC.cMS = str3;
        this.cMC.cMT = str4;
        this.cMC.cMU = str5;
        this.cMC.cMV = str6;
        return this;
    }

    public a e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cMC.cMW = i;
        this.cMC.cMX = i2;
        this.cMC.cMY = i3;
        this.cMC.cMZ = i4;
        this.cMC.cNa = i5;
        this.cMC.cNb = i6;
        return this;
    }

    public a fS(boolean z) {
        this.cMC.cNv = z;
        return this;
    }

    public b ayw() {
        return new b(this.cMC);
    }
}
