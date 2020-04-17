package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a eqW = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.eqW.context = context;
        this.eqW.eqX = eVar;
    }

    public a a(boolean[] zArr) {
        this.eqW.ere = zArr;
        return this;
    }

    public a in(boolean z) {
        this.eqW.erM = z;
        return this;
    }

    public a w(ViewGroup viewGroup) {
        this.eqW.decorView = viewGroup;
        return this;
    }

    public a nP(int i) {
        this.eqW.erH = i;
        return this;
    }

    public a nQ(int i) {
        this.eqW.erL = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.eqW.erf = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.eqW.erz = i;
        this.eqW.eqZ = aVar;
        return this;
    }

    public a ae(float f) {
        this.eqW.lineSpacingMultiplier = f;
        return this;
    }

    public a nR(int i) {
        this.eqW.dividerColor = i;
        return this;
    }

    public a nS(int i) {
        this.eqW.backgroundId = i;
        return this;
    }

    public a nT(int i) {
        this.eqW.textColorCenter = i;
        return this;
    }

    public a nU(int i) {
        this.eqW.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.eqW.erm = str;
        this.eqW.ern = str2;
        this.eqW.ero = str3;
        this.eqW.erp = str4;
        this.eqW.erq = str5;
        this.eqW.ers = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.eqW.ert = i;
        this.eqW.eru = i2;
        this.eqW.erv = i3;
        this.eqW.erw = i4;
        this.eqW.erx = i5;
        this.eqW.ery = i6;
        return this;
    }

    public a io(boolean z) {
        this.eqW.isCenterLabel = z;
        return this;
    }

    public b bdg() {
        return new b(this.eqW);
    }
}
