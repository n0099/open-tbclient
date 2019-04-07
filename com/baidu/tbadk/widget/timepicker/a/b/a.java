package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a cEs = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.cEs.context = context;
        this.cEs.cEt = eVar;
    }

    public a b(boolean[] zArr) {
        this.cEs.cEA = zArr;
        return this;
    }

    public a kP(int i) {
        this.cEs.cFa = i;
        return this;
    }

    public a kQ(int i) {
        this.cEs.cFe = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.cEs.cEB = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.cEs.cES = i;
        this.cEs.cEv = aVar;
        return this;
    }

    public a at(float f) {
        this.cEs.cFi = f;
        return this;
    }

    public a kR(int i) {
        this.cEs.cFh = i;
        return this;
    }

    public a kS(int i) {
        this.cEs.cog = i;
        return this;
    }

    public a kT(int i) {
        this.cEs.cFg = i;
        return this;
    }

    public a kU(int i) {
        this.cEs.cFf = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cEs.cEG = str;
        this.cEs.cEH = str2;
        this.cEs.cEI = str3;
        this.cEs.cEJ = str4;
        this.cEs.cEK = str5;
        this.cEs.cEL = str6;
        return this;
    }

    public a e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cEs.cEM = i;
        this.cEs.cEN = i2;
        this.cEs.cEO = i3;
        this.cEs.cEP = i4;
        this.cEs.cEQ = i5;
        this.cEs.cER = i6;
        return this;
    }

    public a fv(boolean z) {
        this.cEs.cFl = z;
        return this;
    }

    public b atr() {
        return new b(this.cEs);
    }
}
