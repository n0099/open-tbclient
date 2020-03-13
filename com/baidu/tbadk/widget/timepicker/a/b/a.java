package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a dQI = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.dQI.context = context;
        this.dQI.dQJ = eVar;
    }

    public a a(boolean[] zArr) {
        this.dQI.dQQ = zArr;
        return this;
    }

    public a ho(boolean z) {
        this.dQI.dRx = z;
        return this;
    }

    public a v(ViewGroup viewGroup) {
        this.dQI.decorView = viewGroup;
        return this;
    }

    public a nA(int i) {
        this.dQI.dRs = i;
        return this;
    }

    public a nB(int i) {
        this.dQI.dRw = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.dQI.dQR = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.dQI.dRk = i;
        this.dQI.dQL = aVar;
        return this;
    }

    public a au(float f) {
        this.dQI.lineSpacingMultiplier = f;
        return this;
    }

    public a nC(int i) {
        this.dQI.dividerColor = i;
        return this;
    }

    public a nD(int i) {
        this.dQI.backgroundId = i;
        return this;
    }

    public a nE(int i) {
        this.dQI.textColorCenter = i;
        return this;
    }

    public a nF(int i) {
        this.dQI.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.dQI.dQY = str;
        this.dQI.dQZ = str2;
        this.dQI.dRa = str3;
        this.dQI.dRb = str4;
        this.dQI.dRc = str5;
        this.dQI.dRd = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.dQI.dRe = i;
        this.dQI.dRf = i2;
        this.dQI.dRg = i3;
        this.dQI.dRh = i4;
        this.dQI.dRi = i5;
        this.dQI.dRj = i6;
        return this;
    }

    public a hp(boolean z) {
        this.dQI.isCenterLabel = z;
        return this;
    }

    public b aUS() {
        return new b(this.dQI);
    }
}
