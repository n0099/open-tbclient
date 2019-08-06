package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a cOe = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.cOe.context = context;
        this.cOe.cOf = eVar;
    }

    public a b(boolean[] zArr) {
        this.cOe.cOm = zArr;
        return this;
    }

    public a lL(int i) {
        this.cOe.cOO = i;
        return this;
    }

    public a lM(int i) {
        this.cOe.cOS = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.cOe.cOn = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.cOe.cOG = i;
        this.cOe.cOh = aVar;
        return this;
    }

    public a av(float f) {
        this.cOe.cOW = f;
        return this;
    }

    public a lN(int i) {
        this.cOe.cOV = i;
        return this;
    }

    public a lO(int i) {
        this.cOe.cxL = i;
        return this;
    }

    public a lP(int i) {
        this.cOe.cOU = i;
        return this;
    }

    public a lQ(int i) {
        this.cOe.cOT = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cOe.cOu = str;
        this.cOe.cOv = str2;
        this.cOe.cOw = str3;
        this.cOe.cOx = str4;
        this.cOe.cOy = str5;
        this.cOe.cOz = str6;
        return this;
    }

    public a f(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cOe.cOA = i;
        this.cOe.cOB = i2;
        this.cOe.cOC = i3;
        this.cOe.cOD = i4;
        this.cOe.cOE = i5;
        this.cOe.cOF = i6;
        return this;
    }

    public a fW(boolean z) {
        this.cOe.cOZ = z;
        return this;
    }

    public b azL() {
        return new b(this.cOe);
    }
}
