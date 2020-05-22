package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a eFC = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.eFC.context = context;
        this.eFC.eFD = eVar;
    }

    public a a(boolean[] zArr) {
        this.eFC.eFK = zArr;
        return this;
    }

    public a iK(boolean z) {
        this.eFC.eGr = z;
        return this;
    }

    public a A(ViewGroup viewGroup) {
        this.eFC.decorView = viewGroup;
        return this;
    }

    public a ou(int i) {
        this.eFC.eGm = i;
        return this;
    }

    public a ov(int i) {
        this.eFC.eGq = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.eFC.eFL = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.eFC.eGe = i;
        this.eFC.eFF = aVar;
        return this;
    }

    public a ac(float f) {
        this.eFC.lineSpacingMultiplier = f;
        return this;
    }

    public a ow(int i) {
        this.eFC.dividerColor = i;
        return this;
    }

    public a ox(int i) {
        this.eFC.backgroundId = i;
        return this;
    }

    public a oy(int i) {
        this.eFC.textColorCenter = i;
        return this;
    }

    public a oz(int i) {
        this.eFC.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.eFC.eFS = str;
        this.eFC.eFT = str2;
        this.eFC.eFU = str3;
        this.eFC.eFV = str4;
        this.eFC.eFW = str5;
        this.eFC.eFX = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.eFC.eFY = i;
        this.eFC.eFZ = i2;
        this.eFC.eGa = i3;
        this.eFC.eGb = i4;
        this.eFC.eGc = i5;
        this.eFC.eGd = i6;
        return this;
    }

    public a iL(boolean z) {
        this.eFC.isCenterLabel = z;
        return this;
    }

    public b bjp() {
        return new b(this.eFC);
    }
}
