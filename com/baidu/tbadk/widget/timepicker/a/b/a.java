package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a boS = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.boS.context = context;
        this.boS.boT = eVar;
    }

    public a b(boolean[] zArr) {
        this.boS.bpa = zArr;
        return this;
    }

    public a gL(int i) {
        this.boS.bpA = i;
        return this;
    }

    public a gM(int i) {
        this.boS.bpE = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.boS.bpb = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.boS.bps = i;
        this.boS.boV = aVar;
        return this;
    }

    public a ae(float f) {
        this.boS.bpI = f;
        return this;
    }

    public a gN(int i) {
        this.boS.bpH = i;
        return this;
    }

    public a gO(int i) {
        this.boS.ban = i;
        return this;
    }

    public a gP(int i) {
        this.boS.bpG = i;
        return this;
    }

    public a gQ(int i) {
        this.boS.bpF = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.boS.bpg = str;
        this.boS.bph = str2;
        this.boS.bpi = str3;
        this.boS.bpj = str4;
        this.boS.bpk = str5;
        this.boS.bpl = str6;
        return this;
    }

    public a e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.boS.bpm = i;
        this.boS.bpn = i2;
        this.boS.bpo = i3;
        this.boS.bpp = i4;
        this.boS.bpq = i5;
        this.boS.bpr = i6;
        return this;
    }

    public a db(boolean z) {
        this.boS.bpL = z;
        return this;
    }

    public b RR() {
        return new b(this.boS);
    }
}
