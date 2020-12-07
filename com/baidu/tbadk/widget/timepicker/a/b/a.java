package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes21.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a fRN = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.fRN.context = context;
        this.fRN.fRO = eVar;
    }

    public a a(boolean[] zArr) {
        this.fRN.fRV = zArr;
        return this;
    }

    public a lr(boolean z) {
        this.fRN.fSC = z;
        return this;
    }

    public a G(ViewGroup viewGroup) {
        this.fRN.decorView = viewGroup;
        return this;
    }

    public a tI(int i) {
        this.fRN.fSx = i;
        return this;
    }

    public a tJ(int i) {
        this.fRN.fSB = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.fRN.fRW = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.fRN.fSp = i;
        this.fRN.fRQ = aVar;
        return this;
    }

    public a as(float f) {
        this.fRN.lineSpacingMultiplier = f;
        return this;
    }

    public a tK(int i) {
        this.fRN.dividerColor = i;
        return this;
    }

    public a tL(int i) {
        this.fRN.backgroundId = i;
        return this;
    }

    public a tM(int i) {
        this.fRN.textColorCenter = i;
        return this;
    }

    public a tN(int i) {
        this.fRN.textColorOut = i;
        return this;
    }

    public a c(String str, String str2, String str3, String str4, String str5, String str6) {
        this.fRN.fSd = str;
        this.fRN.fSe = str2;
        this.fRN.fSf = str3;
        this.fRN.fSg = str4;
        this.fRN.fSh = str5;
        this.fRN.fSi = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fRN.fSj = i;
        this.fRN.fSk = i2;
        this.fRN.fSl = i3;
        this.fRN.fSm = i4;
        this.fRN.fSn = i5;
        this.fRN.fSo = i6;
        return this;
    }

    public a ls(boolean z) {
        this.fRN.isCenterLabel = z;
        return this;
    }

    public b bJE() {
        return new b(this.fRN);
    }
}
