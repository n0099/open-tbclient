package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes21.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a fKz = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.fKz.context = context;
        this.fKz.fKA = eVar;
    }

    public a a(boolean[] zArr) {
        this.fKz.fKH = zArr;
        return this;
    }

    public a kW(boolean z) {
        this.fKz.fLo = z;
        return this;
    }

    public a K(ViewGroup viewGroup) {
        this.fKz.decorView = viewGroup;
        return this;
    }

    public a sH(int i) {
        this.fKz.fLj = i;
        return this;
    }

    public a sI(int i) {
        this.fKz.fLn = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.fKz.fKI = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.fKz.fLb = i;
        this.fKz.fKC = aVar;
        return this;
    }

    public a ap(float f) {
        this.fKz.lineSpacingMultiplier = f;
        return this;
    }

    public a sJ(int i) {
        this.fKz.dividerColor = i;
        return this;
    }

    public a sK(int i) {
        this.fKz.backgroundId = i;
        return this;
    }

    public a sL(int i) {
        this.fKz.textColorCenter = i;
        return this;
    }

    public a sM(int i) {
        this.fKz.textColorOut = i;
        return this;
    }

    public a c(String str, String str2, String str3, String str4, String str5, String str6) {
        this.fKz.fKP = str;
        this.fKz.fKQ = str2;
        this.fKz.fKR = str3;
        this.fKz.fKS = str4;
        this.fKz.fKT = str5;
        this.fKz.fKU = str6;
        return this;
    }

    public a f(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fKz.fKV = i;
        this.fKz.fKW = i2;
        this.fKz.fKX = i3;
        this.fKz.fKY = i4;
        this.fKz.fKZ = i5;
        this.fKz.fLa = i6;
        return this;
    }

    public a kX(boolean z) {
        this.fKz.isCenterLabel = z;
        return this;
    }

    public b bGL() {
        return new b(this.fKz);
    }
}
