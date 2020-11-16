package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes20.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a fKc = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.fKc.context = context;
        this.fKc.fKd = eVar;
    }

    public a a(boolean[] zArr) {
        this.fKc.fKk = zArr;
        return this;
    }

    public a kX(boolean z) {
        this.fKc.fKR = z;
        return this;
    }

    public a G(ViewGroup viewGroup) {
        this.fKc.decorView = viewGroup;
        return this;
    }

    public a tf(int i) {
        this.fKc.fKM = i;
        return this;
    }

    public a tg(int i) {
        this.fKc.fKQ = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.fKc.fKl = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.fKc.fKE = i;
        this.fKc.fKf = aVar;
        return this;
    }

    public a ar(float f) {
        this.fKc.lineSpacingMultiplier = f;
        return this;
    }

    public a th(int i) {
        this.fKc.dividerColor = i;
        return this;
    }

    public a ti(int i) {
        this.fKc.backgroundId = i;
        return this;
    }

    public a tj(int i) {
        this.fKc.textColorCenter = i;
        return this;
    }

    public a tk(int i) {
        this.fKc.textColorOut = i;
        return this;
    }

    public a c(String str, String str2, String str3, String str4, String str5, String str6) {
        this.fKc.fKs = str;
        this.fKc.fKt = str2;
        this.fKc.fKu = str3;
        this.fKc.fKv = str4;
        this.fKc.fKw = str5;
        this.fKc.fKx = str6;
        return this;
    }

    public a f(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fKc.fKy = i;
        this.fKc.fKz = i2;
        this.fKc.fKA = i3;
        this.fKc.fKB = i4;
        this.fKc.fKC = i5;
        this.fKc.fKD = i6;
        return this;
    }

    public a kY(boolean z) {
        this.fKc.isCenterLabel = z;
        return this;
    }

    public b bGe() {
        return new b(this.fKc);
    }
}
