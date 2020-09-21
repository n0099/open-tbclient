package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes20.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a fka = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.fka.context = context;
        this.fka.fkb = eVar;
    }

    public a a(boolean[] zArr) {
        this.fka.fki = zArr;
        return this;
    }

    public a kc(boolean z) {
        this.fka.fkP = z;
        return this;
    }

    public a F(ViewGroup viewGroup) {
        this.fka.decorView = viewGroup;
        return this;
    }

    public a rO(int i) {
        this.fka.fkK = i;
        return this;
    }

    public a rP(int i) {
        this.fka.fkO = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.fka.fkj = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.fka.fkC = i;
        this.fka.fkd = aVar;
        return this;
    }

    public a aj(float f) {
        this.fka.lineSpacingMultiplier = f;
        return this;
    }

    public a rQ(int i) {
        this.fka.dividerColor = i;
        return this;
    }

    public a rR(int i) {
        this.fka.backgroundId = i;
        return this;
    }

    public a rS(int i) {
        this.fka.textColorCenter = i;
        return this;
    }

    public a rT(int i) {
        this.fka.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.fka.fkq = str;
        this.fka.fkr = str2;
        this.fka.fks = str3;
        this.fka.fkt = str4;
        this.fka.fku = str5;
        this.fka.fkv = str6;
        return this;
    }

    public a f(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fka.fkw = i;
        this.fka.fkx = i2;
        this.fka.fky = i3;
        this.fka.fkz = i4;
        this.fka.fkA = i5;
        this.fka.fkB = i6;
        return this;
    }

    public a kd(boolean z) {
        this.fka.isCenterLabel = z;
        return this;
    }

    public b bzJ() {
        return new b(this.fka);
    }
}
