package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes15.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a fhg = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.fhg.context = context;
        this.fhg.fhh = eVar;
    }

    public a a(boolean[] zArr) {
        this.fhg.fho = zArr;
        return this;
    }

    public a kb(boolean z) {
        this.fhg.fhV = z;
        return this;
    }

    public a E(ViewGroup viewGroup) {
        this.fhg.decorView = viewGroup;
        return this;
    }

    public a rx(int i) {
        this.fhg.fhQ = i;
        return this;
    }

    public a ry(int i) {
        this.fhg.fhU = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.fhg.fhp = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.fhg.fhI = i;
        this.fhg.fhj = aVar;
        return this;
    }

    public a aj(float f) {
        this.fhg.lineSpacingMultiplier = f;
        return this;
    }

    public a rz(int i) {
        this.fhg.dividerColor = i;
        return this;
    }

    public a rA(int i) {
        this.fhg.backgroundId = i;
        return this;
    }

    public a rB(int i) {
        this.fhg.textColorCenter = i;
        return this;
    }

    public a rC(int i) {
        this.fhg.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.fhg.fhw = str;
        this.fhg.fhx = str2;
        this.fhg.fhy = str3;
        this.fhg.fhz = str4;
        this.fhg.fhA = str5;
        this.fhg.fhB = str6;
        return this;
    }

    public a f(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fhg.fhC = i;
        this.fhg.fhD = i2;
        this.fhg.fhE = i3;
        this.fhg.fhF = i4;
        this.fhg.fhG = i5;
        this.fhg.fhH = i6;
        return this;
    }

    public a kc(boolean z) {
        this.fhg.isCenterLabel = z;
        return this;
    }

    public b byA() {
        return new b(this.fhg);
    }
}
