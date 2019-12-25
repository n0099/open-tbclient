package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes5.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a dMf = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.dMf.context = context;
        this.dMf.dMg = eVar;
    }

    public a a(boolean[] zArr) {
        this.dMf.dMn = zArr;
        return this;
    }

    public a hc(boolean z) {
        this.dMf.dMU = z;
        return this;
    }

    public a r(ViewGroup viewGroup) {
        this.dMf.decorView = viewGroup;
        return this;
    }

    public a nj(int i) {
        this.dMf.dMP = i;
        return this;
    }

    public a nk(int i) {
        this.dMf.dMT = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.dMf.dMo = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.dMf.dMH = i;
        this.dMf.dMi = aVar;
        return this;
    }

    public a aw(float f) {
        this.dMf.lineSpacingMultiplier = f;
        return this;
    }

    public a nl(int i) {
        this.dMf.dividerColor = i;
        return this;
    }

    public a nm(int i) {
        this.dMf.backgroundId = i;
        return this;
    }

    public a nn(int i) {
        this.dMf.textColorCenter = i;
        return this;
    }

    public a no(int i) {
        this.dMf.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.dMf.dMv = str;
        this.dMf.dMw = str2;
        this.dMf.dMx = str3;
        this.dMf.dMy = str4;
        this.dMf.dMz = str5;
        this.dMf.dMA = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.dMf.dMB = i;
        this.dMf.dMC = i2;
        this.dMf.dMD = i3;
        this.dMf.dME = i4;
        this.dMf.dMF = i5;
        this.dMf.dMG = i6;
        return this;
    }

    public a hd(boolean z) {
        this.dMf.isCenterLabel = z;
        return this;
    }

    public b aSe() {
        return new b(this.dMf);
    }
}
