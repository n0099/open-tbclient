package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a cNX = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.cNX.context = context;
        this.cNX.cNY = eVar;
    }

    public a b(boolean[] zArr) {
        this.cNX.cOf = zArr;
        return this;
    }

    public a lK(int i) {
        this.cNX.cOH = i;
        return this;
    }

    public a lL(int i) {
        this.cNX.cOL = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.cNX.cOg = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.cNX.cOz = i;
        this.cNX.cOa = aVar;
        return this;
    }

    public a av(float f) {
        this.cNX.cOP = f;
        return this;
    }

    public a lM(int i) {
        this.cNX.cOO = i;
        return this;
    }

    public a lN(int i) {
        this.cNX.cxE = i;
        return this;
    }

    public a lO(int i) {
        this.cNX.cON = i;
        return this;
    }

    public a lP(int i) {
        this.cNX.cOM = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cNX.cOn = str;
        this.cNX.cOo = str2;
        this.cNX.cOp = str3;
        this.cNX.cOq = str4;
        this.cNX.cOr = str5;
        this.cNX.cOs = str6;
        return this;
    }

    public a f(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cNX.cOt = i;
        this.cNX.cOu = i2;
        this.cNX.cOv = i3;
        this.cNX.cOw = i4;
        this.cNX.cOx = i5;
        this.cNX.cOy = i6;
        return this;
    }

    public a fW(boolean z) {
        this.cNX.cOS = z;
        return this;
    }

    public b azJ() {
        return new b(this.cNX);
    }
}
