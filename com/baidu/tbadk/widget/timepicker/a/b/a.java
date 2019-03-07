package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a cEt = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.cEt.context = context;
        this.cEt.cEu = eVar;
    }

    public a b(boolean[] zArr) {
        this.cEt.cEB = zArr;
        return this;
    }

    public a kQ(int i) {
        this.cEt.cFb = i;
        return this;
    }

    public a kR(int i) {
        this.cEt.cFf = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.cEt.cEC = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.cEt.cET = i;
        this.cEt.cEw = aVar;
        return this;
    }

    public a at(float f) {
        this.cEt.cFj = f;
        return this;
    }

    public a kS(int i) {
        this.cEt.cFi = i;
        return this;
    }

    public a kT(int i) {
        this.cEt.coe = i;
        return this;
    }

    public a kU(int i) {
        this.cEt.cFh = i;
        return this;
    }

    public a kV(int i) {
        this.cEt.cFg = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cEt.cEH = str;
        this.cEt.cEI = str2;
        this.cEt.cEJ = str3;
        this.cEt.cEK = str4;
        this.cEt.cEL = str5;
        this.cEt.cEM = str6;
        return this;
    }

    public a e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cEt.cEN = i;
        this.cEt.cEO = i2;
        this.cEt.cEP = i3;
        this.cEt.cEQ = i4;
        this.cEt.cER = i5;
        this.cEt.cES = i6;
        return this;
    }

    public a fv(boolean z) {
        this.cEt.cFm = z;
        return this;
    }

    public b atu() {
        return new b(this.cEt);
    }
}
