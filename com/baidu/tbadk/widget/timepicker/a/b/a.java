package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a dQZ = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.dQZ.context = context;
        this.dQZ.dRa = eVar;
    }

    public a a(boolean[] zArr) {
        this.dQZ.dRh = zArr;
        return this;
    }

    public a hp(boolean z) {
        this.dQZ.dRO = z;
        return this;
    }

    public a v(ViewGroup viewGroup) {
        this.dQZ.decorView = viewGroup;
        return this;
    }

    public a nC(int i) {
        this.dQZ.dRJ = i;
        return this;
    }

    public a nD(int i) {
        this.dQZ.dRN = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.dQZ.dRi = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.dQZ.dRB = i;
        this.dQZ.dRc = aVar;
        return this;
    }

    public a au(float f) {
        this.dQZ.lineSpacingMultiplier = f;
        return this;
    }

    public a nE(int i) {
        this.dQZ.dividerColor = i;
        return this;
    }

    public a nF(int i) {
        this.dQZ.backgroundId = i;
        return this;
    }

    public a nG(int i) {
        this.dQZ.textColorCenter = i;
        return this;
    }

    public a nH(int i) {
        this.dQZ.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.dQZ.dRp = str;
        this.dQZ.dRq = str2;
        this.dQZ.dRr = str3;
        this.dQZ.dRs = str4;
        this.dQZ.dRt = str5;
        this.dQZ.dRu = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.dQZ.dRv = i;
        this.dQZ.dRw = i2;
        this.dQZ.dRx = i3;
        this.dQZ.dRy = i4;
        this.dQZ.dRz = i5;
        this.dQZ.dRA = i6;
        return this;
    }

    public a hq(boolean z) {
        this.dQZ.isCenterLabel = z;
        return this;
    }

    public b aUW() {
        return new b(this.dQZ);
    }
}
