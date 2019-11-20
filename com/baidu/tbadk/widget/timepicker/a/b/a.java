package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a cXv = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.cXv.context = context;
        this.cXv.cXw = eVar;
    }

    public a b(boolean[] zArr) {
        this.cXv.cXD = zArr;
        return this;
    }

    public a kT(int i) {
        this.cXv.cYf = i;
        return this;
    }

    public a kU(int i) {
        this.cXv.cYj = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.cXv.cXE = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.cXv.cXX = i;
        this.cXv.cXy = aVar;
        return this;
    }

    public a ah(float f) {
        this.cXv.cYn = f;
        return this;
    }

    public a kV(int i) {
        this.cXv.cYm = i;
        return this;
    }

    public a kW(int i) {
        this.cXv.backgroundId = i;
        return this;
    }

    public a kX(int i) {
        this.cXv.cYl = i;
        return this;
    }

    public a kY(int i) {
        this.cXv.cYk = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cXv.cXL = str;
        this.cXv.cXM = str2;
        this.cXv.cXN = str3;
        this.cXv.cXO = str4;
        this.cXv.cXP = str5;
        this.cXv.cXQ = str6;
        return this;
    }

    public a f(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cXv.cXR = i;
        this.cXv.cXS = i2;
        this.cXv.cXT = i3;
        this.cXv.cXU = i4;
        this.cXv.cXV = i5;
        this.cXv.cXW = i6;
        return this;
    }

    public a fO(boolean z) {
        this.cXv.cYq = z;
        return this;
    }

    public b aAe() {
        return new b(this.cXv);
    }
}
