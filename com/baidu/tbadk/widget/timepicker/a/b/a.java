package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a gbr = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.gbr.context = context;
        this.gbr.gbs = eVar;
    }

    public a a(boolean[] zArr) {
        this.gbr.gbz = zArr;
        return this;
    }

    public a lN(boolean z) {
        this.gbr.gcg = z;
        return this;
    }

    public a N(ViewGroup viewGroup) {
        this.gbr.decorView = viewGroup;
        return this;
    }

    public a tT(int i) {
        this.gbr.gcb = i;
        return this;
    }

    public a tU(int i) {
        this.gbr.gcf = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.gbr.gbA = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.gbr.gbT = i;
        this.gbr.gbu = aVar;
        return this;
    }

    public a au(float f) {
        this.gbr.dCW = f;
        return this;
    }

    public a tV(int i) {
        this.gbr.dCV = i;
        return this;
    }

    public a tW(int i) {
        this.gbr.backgroundId = i;
        return this;
    }

    public a tX(int i) {
        this.gbr.dCU = i;
        return this;
    }

    public a tY(int i) {
        this.gbr.dCT = i;
        return this;
    }

    public a d(String str, String str2, String str3, String str4, String str5, String str6) {
        this.gbr.gbH = str;
        this.gbr.gbI = str2;
        this.gbr.gbJ = str3;
        this.gbr.gbK = str4;
        this.gbr.gbL = str5;
        this.gbr.gbM = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.gbr.gbN = i;
        this.gbr.gbO = i2;
        this.gbr.gbP = i3;
        this.gbr.gbQ = i4;
        this.gbr.gbR = i5;
        this.gbr.gbS = i6;
        return this;
    }

    public a lO(boolean z) {
        this.gbr.dCG = z;
        return this;
    }

    public b bLX() {
        return new b(this.gbr);
    }
}
