package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a btg = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.btg.context = context;
        this.btg.bth = eVar;
    }

    public a b(boolean[] zArr) {
        this.btg.btp = zArr;
        return this;
    }

    public a ha(int i) {
        this.btg.btP = i;
        return this;
    }

    public a hb(int i) {
        this.btg.btT = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.btg.btq = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.btg.btH = i;
        this.btg.btj = aVar;
        return this;
    }

    public a ae(float f) {
        this.btg.btX = f;
        return this;
    }

    public a hc(int i) {
        this.btg.btW = i;
        return this;
    }

    public a hd(int i) {
        this.btg.beA = i;
        return this;
    }

    public a he(int i) {
        this.btg.btV = i;
        return this;
    }

    public a hf(int i) {
        this.btg.btU = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.btg.btv = str;
        this.btg.btw = str2;
        this.btg.btx = str3;
        this.btg.bty = str4;
        this.btg.btz = str5;
        this.btg.btA = str6;
        return this;
    }

    public a e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.btg.btB = i;
        this.btg.btC = i2;
        this.btg.btD = i3;
        this.btg.btE = i4;
        this.btg.btF = i5;
        this.btg.btG = i6;
        return this;
    }

    public a df(boolean z) {
        this.btg.bua = z;
        return this;
    }

    public b Tv() {
        return new b(this.btg);
    }
}
