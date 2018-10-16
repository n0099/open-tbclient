package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a bog = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.bog.context = context;
        this.bog.boh = eVar;
    }

    public a b(boolean[] zArr) {
        this.bog.boo = zArr;
        return this;
    }

    public a gx(int i) {
        this.bog.boO = i;
        return this;
    }

    public a gy(int i) {
        this.bog.boS = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.bog.bop = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.bog.boG = i;
        this.bog.boj = aVar;
        return this;
    }

    public a ae(float f) {
        this.bog.boW = f;
        return this;
    }

    public a gz(int i) {
        this.bog.boV = i;
        return this;
    }

    public a gA(int i) {
        this.bog.aZA = i;
        return this;
    }

    public a gB(int i) {
        this.bog.boU = i;
        return this;
    }

    public a gC(int i) {
        this.bog.boT = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.bog.bou = str;
        this.bog.bov = str2;
        this.bog.bow = str3;
        this.bog.box = str4;
        this.bog.boy = str5;
        this.bog.boz = str6;
        return this;
    }

    public a d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bog.boA = i;
        this.bog.boB = i2;
        this.bog.boC = i3;
        this.bog.boD = i4;
        this.bog.boE = i5;
        this.bog.boF = i6;
        return this;
    }

    public a cK(boolean z) {
        this.bog.boZ = z;
        return this;
    }

    public b RI() {
        return new b(this.bog);
    }
}
