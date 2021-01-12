package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a fWJ = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.fWJ.context = context;
        this.fWJ.fWK = eVar;
    }

    public a a(boolean[] zArr) {
        this.fWJ.fWR = zArr;
        return this;
    }

    public a lJ(boolean z) {
        this.fWJ.fXy = z;
        return this;
    }

    public a N(ViewGroup viewGroup) {
        this.fWJ.decorView = viewGroup;
        return this;
    }

    public a sn(int i) {
        this.fWJ.fXt = i;
        return this;
    }

    public a so(int i) {
        this.fWJ.fXx = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.fWJ.fWS = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.fWJ.fXl = i;
        this.fWJ.fWM = aVar;
        return this;
    }

    public a au(float f) {
        this.fWJ.dyk = f;
        return this;
    }

    public a sp(int i) {
        this.fWJ.dyj = i;
        return this;
    }

    public a sq(int i) {
        this.fWJ.backgroundId = i;
        return this;
    }

    public a sr(int i) {
        this.fWJ.dyi = i;
        return this;
    }

    public a ss(int i) {
        this.fWJ.dyh = i;
        return this;
    }

    public a d(String str, String str2, String str3, String str4, String str5, String str6) {
        this.fWJ.fWZ = str;
        this.fWJ.fXa = str2;
        this.fWJ.fXb = str3;
        this.fWJ.fXc = str4;
        this.fWJ.fXd = str5;
        this.fWJ.fXe = str6;
        return this;
    }

    public a h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fWJ.fXf = i;
        this.fWJ.fXg = i2;
        this.fWJ.fXh = i3;
        this.fWJ.fXi = i4;
        this.fWJ.fXj = i5;
        this.fWJ.fXk = i6;
        return this;
    }

    public a lK(boolean z) {
        this.fWJ.dxU = z;
        return this;
    }

    public b bIf() {
        return new b(this.fWJ);
    }
}
