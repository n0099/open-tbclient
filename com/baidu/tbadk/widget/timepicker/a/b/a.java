package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a cOU = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.cOU.context = context;
        this.cOU.cOV = eVar;
    }

    public a b(boolean[] zArr) {
        this.cOU.cPc = zArr;
        return this;
    }

    public a lP(int i) {
        this.cOU.cPE = i;
        return this;
    }

    public a lQ(int i) {
        this.cOU.cPI = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.cOU.cPd = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.cOU.cPw = i;
        this.cOU.cOX = aVar;
        return this;
    }

    public a av(float f) {
        this.cOU.cPM = f;
        return this;
    }

    public a lR(int i) {
        this.cOU.cPL = i;
        return this;
    }

    public a lS(int i) {
        this.cOU.cyH = i;
        return this;
    }

    public a lT(int i) {
        this.cOU.cPK = i;
        return this;
    }

    public a lU(int i) {
        this.cOU.cPJ = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cOU.cPk = str;
        this.cOU.cPl = str2;
        this.cOU.cPm = str3;
        this.cOU.cPn = str4;
        this.cOU.cPo = str5;
        this.cOU.cPp = str6;
        return this;
    }

    public a f(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cOU.cPq = i;
        this.cOU.cPr = i2;
        this.cOU.cPs = i3;
        this.cOU.cPt = i4;
        this.cOU.cPu = i5;
        this.cOU.cPv = i6;
        return this;
    }

    public a fZ(boolean z) {
        this.cOU.cPP = z;
        return this;
    }

    public b azX() {
        return new b(this.cOU);
    }
}
