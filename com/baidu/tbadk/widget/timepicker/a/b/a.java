package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes15.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a fhc = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.fhc.context = context;
        this.fhc.fhd = eVar;
    }

    public a a(boolean[] zArr) {
        this.fhc.fhk = zArr;
        return this;
    }

    public a jZ(boolean z) {
        this.fhc.fhR = z;
        return this;
    }

    public a E(ViewGroup viewGroup) {
        this.fhc.decorView = viewGroup;
        return this;
    }

    public a rx(int i) {
        this.fhc.fhM = i;
        return this;
    }

    public a ry(int i) {
        this.fhc.fhQ = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.fhc.fhl = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.fhc.fhE = i;
        this.fhc.fhf = aVar;
        return this;
    }

    public a aj(float f) {
        this.fhc.lineSpacingMultiplier = f;
        return this;
    }

    public a rz(int i) {
        this.fhc.dividerColor = i;
        return this;
    }

    public a rA(int i) {
        this.fhc.backgroundId = i;
        return this;
    }

    public a rB(int i) {
        this.fhc.textColorCenter = i;
        return this;
    }

    public a rC(int i) {
        this.fhc.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.fhc.fhs = str;
        this.fhc.fht = str2;
        this.fhc.fhu = str3;
        this.fhc.fhv = str4;
        this.fhc.fhw = str5;
        this.fhc.fhx = str6;
        return this;
    }

    public a f(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fhc.fhy = i;
        this.fhc.fhz = i2;
        this.fhc.fhA = i3;
        this.fhc.fhB = i4;
        this.fhc.fhC = i5;
        this.fhc.fhD = i6;
        return this;
    }

    public a ka(boolean z) {
        this.fhc.isCenterLabel = z;
        return this;
    }

    public b byz() {
        return new b(this.fhc);
    }
}
