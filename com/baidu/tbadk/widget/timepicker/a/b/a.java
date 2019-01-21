package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a bth = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.bth.context = context;
        this.bth.bti = eVar;
    }

    public a b(boolean[] zArr) {
        this.bth.btq = zArr;
        return this;
    }

    public a ha(int i) {
        this.bth.btQ = i;
        return this;
    }

    public a hb(int i) {
        this.bth.btU = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.bth.btr = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.bth.btI = i;
        this.bth.btk = aVar;
        return this;
    }

    public a ae(float f) {
        this.bth.btY = f;
        return this;
    }

    public a hc(int i) {
        this.bth.btX = i;
        return this;
    }

    public a hd(int i) {
        this.bth.beB = i;
        return this;
    }

    public a he(int i) {
        this.bth.btW = i;
        return this;
    }

    public a hf(int i) {
        this.bth.btV = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.bth.btw = str;
        this.bth.btx = str2;
        this.bth.bty = str3;
        this.bth.btz = str4;
        this.bth.btA = str5;
        this.bth.btB = str6;
        return this;
    }

    public a e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bth.btC = i;
        this.bth.btD = i2;
        this.bth.btE = i3;
        this.bth.btF = i4;
        this.bth.btG = i5;
        this.bth.btH = i6;
        return this;
    }

    public a df(boolean z) {
        this.bth.bub = z;
        return this;
    }

    public b Tv() {
        return new b(this.bth);
    }
}
