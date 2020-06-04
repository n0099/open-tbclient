package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a eFN = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.eFN.context = context;
        this.eFN.eFO = eVar;
    }

    public a a(boolean[] zArr) {
        this.eFN.eFV = zArr;
        return this;
    }

    public a iK(boolean z) {
        this.eFN.eGC = z;
        return this;
    }

    public a A(ViewGroup viewGroup) {
        this.eFN.decorView = viewGroup;
        return this;
    }

    public a ow(int i) {
        this.eFN.eGx = i;
        return this;
    }

    public a ox(int i) {
        this.eFN.eGB = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.eFN.eFW = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.eFN.eGp = i;
        this.eFN.eFQ = aVar;
        return this;
    }

    public a ac(float f) {
        this.eFN.lineSpacingMultiplier = f;
        return this;
    }

    public a oy(int i) {
        this.eFN.dividerColor = i;
        return this;
    }

    public a oz(int i) {
        this.eFN.backgroundId = i;
        return this;
    }

    public a oA(int i) {
        this.eFN.textColorCenter = i;
        return this;
    }

    public a oB(int i) {
        this.eFN.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.eFN.eGd = str;
        this.eFN.eGe = str2;
        this.eFN.eGf = str3;
        this.eFN.eGg = str4;
        this.eFN.eGh = str5;
        this.eFN.eGi = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.eFN.eGj = i;
        this.eFN.eGk = i2;
        this.eFN.eGl = i3;
        this.eFN.eGm = i4;
        this.eFN.eGn = i5;
        this.eFN.eGo = i6;
        return this;
    }

    public a iL(boolean z) {
        this.eFN.isCenterLabel = z;
        return this;
    }

    public b bjr() {
        return new b(this.eFN);
    }
}
