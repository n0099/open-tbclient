package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a cYm = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.cYm.context = context;
        this.cYm.cYn = eVar;
    }

    public a b(boolean[] zArr) {
        this.cYm.cYu = zArr;
        return this;
    }

    public a kU(int i) {
        this.cYm.cYW = i;
        return this;
    }

    public a kV(int i) {
        this.cYm.cZa = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.cYm.cYv = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.cYm.cYO = i;
        this.cYm.cYp = aVar;
        return this;
    }

    public a ah(float f) {
        this.cYm.cZe = f;
        return this;
    }

    public a kW(int i) {
        this.cYm.cZd = i;
        return this;
    }

    public a kX(int i) {
        this.cYm.backgroundId = i;
        return this;
    }

    public a kY(int i) {
        this.cYm.cZc = i;
        return this;
    }

    public a kZ(int i) {
        this.cYm.cZb = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.cYm.cYC = str;
        this.cYm.cYD = str2;
        this.cYm.cYE = str3;
        this.cYm.cYF = str4;
        this.cYm.cYG = str5;
        this.cYm.cYH = str6;
        return this;
    }

    public a f(int i, int i2, int i3, int i4, int i5, int i6) {
        this.cYm.cYI = i;
        this.cYm.cYJ = i2;
        this.cYm.cYK = i3;
        this.cYm.cYL = i4;
        this.cYm.cYM = i5;
        this.cYm.cYN = i6;
        return this;
    }

    public a fO(boolean z) {
        this.cYm.cZh = z;
        return this;
    }

    public b aAg() {
        return new b(this.cYm);
    }
}
