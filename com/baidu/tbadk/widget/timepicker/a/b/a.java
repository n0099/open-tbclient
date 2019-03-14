package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a cEq = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.cEq.context = context;
        this.cEq.cEr = eVar;
    }

    public a b(boolean[] zArr) {
        this.cEq.cEy = zArr;
        return this;
    }

    public a kQ(int i) {
        this.cEq.cEY = i;
        return this;
    }

    public a kR(int i) {
        this.cEq.cFc = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.cEq.cEz = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.cEq.cEQ = i;
        this.cEq.cEt = aVar;
        return this;
    }

    public a at(float f) {
        this.cEq.cFg = f;
        return this;
    }

    public a kS(int i) {
        this.cEq.cFf = i;
        return this;
    }

    public a kT(int i) {
        this.cEq.coe = i;
        return this;
    }

    public a kU(int i) {
        this.cEq.cFe = i;
        return this;
    }

    public a kV(int i) {
        this.cEq.cFd = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cEq.cEE = str;
        this.cEq.cEF = str2;
        this.cEq.cEG = str3;
        this.cEq.cEH = str4;
        this.cEq.cEI = str5;
        this.cEq.cEJ = str6;
        return this;
    }

    public a e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cEq.cEK = i;
        this.cEq.cEL = i2;
        this.cEq.cEM = i3;
        this.cEq.cEN = i4;
        this.cEq.cEO = i5;
        this.cEq.cEP = i6;
        return this;
    }

    public a fv(boolean z) {
        this.cEq.cFj = z;
        return this;
    }

    public b atu() {
        return new b(this.cEq);
    }
}
