package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a dMn = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.dMn.context = context;
        this.dMn.dMo = eVar;
    }

    public a a(boolean[] zArr) {
        this.dMn.dMv = zArr;
        return this;
    }

    public a hh(boolean z) {
        this.dMn.dNc = z;
        return this;
    }

    public a u(ViewGroup viewGroup) {
        this.dMn.decorView = viewGroup;
        return this;
    }

    public a nj(int i) {
        this.dMn.dMX = i;
        return this;
    }

    public a nk(int i) {
        this.dMn.dNb = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.dMn.dMw = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.dMn.dMP = i;
        this.dMn.dMq = aVar;
        return this;
    }

    public a av(float f) {
        this.dMn.lineSpacingMultiplier = f;
        return this;
    }

    public a nl(int i) {
        this.dMn.dividerColor = i;
        return this;
    }

    public a nm(int i) {
        this.dMn.backgroundId = i;
        return this;
    }

    public a nn(int i) {
        this.dMn.textColorCenter = i;
        return this;
    }

    public a no(int i) {
        this.dMn.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.dMn.dMD = str;
        this.dMn.dME = str2;
        this.dMn.dMF = str3;
        this.dMn.dMG = str4;
        this.dMn.dMH = str5;
        this.dMn.dMI = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.dMn.dMJ = i;
        this.dMn.dMK = i2;
        this.dMn.dML = i3;
        this.dMn.dMM = i4;
        this.dMn.dMN = i5;
        this.dMn.dMO = i6;
        return this;
    }

    public a hi(boolean z) {
        this.dMn.isCenterLabel = z;
        return this;
    }

    public b aSy() {
        return new b(this.dMn);
    }
}
