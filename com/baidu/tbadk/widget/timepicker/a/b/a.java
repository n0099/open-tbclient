package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a cMD = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.cMD.context = context;
        this.cMD.cME = eVar;
    }

    public a b(boolean[] zArr) {
        this.cMD.cML = zArr;
        return this;
    }

    public a lE(int i) {
        this.cMD.cNl = i;
        return this;
    }

    public a lF(int i) {
        this.cMD.cNp = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.cMD.cMM = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.cMD.cNd = i;
        this.cMD.cMG = aVar;
        return this;
    }

    public a av(float f) {
        this.cMD.cNt = f;
        return this;
    }

    public a lG(int i) {
        this.cMD.cNs = i;
        return this;
    }

    public a lH(int i) {
        this.cMD.cwp = i;
        return this;
    }

    public a lI(int i) {
        this.cMD.cNr = i;
        return this;
    }

    public a lJ(int i) {
        this.cMD.cNq = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cMD.cMR = str;
        this.cMD.cMS = str2;
        this.cMD.cMT = str3;
        this.cMD.cMU = str4;
        this.cMD.cMV = str5;
        this.cMD.cMW = str6;
        return this;
    }

    public a e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cMD.cMX = i;
        this.cMD.cMY = i2;
        this.cMD.cMZ = i3;
        this.cMD.cNa = i4;
        this.cMD.cNb = i5;
        this.cMD.cNc = i6;
        return this;
    }

    public a fS(boolean z) {
        this.cMD.cNw = z;
        return this;
    }

    public b ayx() {
        return new b(this.cMD);
    }
}
