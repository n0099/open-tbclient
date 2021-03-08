package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a gaA = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.gaA.context = context;
        this.gaA.gaB = eVar;
    }

    public a a(boolean[] zArr) {
        this.gaA.gaI = zArr;
        return this;
    }

    public a lN(boolean z) {
        this.gaA.gbp = z;
        return this;
    }

    public a L(ViewGroup viewGroup) {
        this.gaA.decorView = viewGroup;
        return this;
    }

    public a su(int i) {
        this.gaA.gbk = i;
        return this;
    }

    public a sv(int i) {
        this.gaA.gbo = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.gaA.gaJ = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.gaA.gbc = i;
        this.gaA.gaD = aVar;
        return this;
    }

    public a az(float f) {
        this.gaA.dBQ = f;
        return this;
    }

    public a sw(int i) {
        this.gaA.dBP = i;
        return this;
    }

    public a sx(int i) {
        this.gaA.backgroundId = i;
        return this;
    }

    public a sy(int i) {
        this.gaA.dBO = i;
        return this;
    }

    public a sz(int i) {
        this.gaA.dBN = i;
        return this;
    }

    public a d(String str, String str2, String str3, String str4, String str5, String str6) {
        this.gaA.gaQ = str;
        this.gaA.gaR = str2;
        this.gaA.gaS = str3;
        this.gaA.gaT = str4;
        this.gaA.gaU = str5;
        this.gaA.gaV = str6;
        return this;
    }

    public a h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.gaA.gaW = i;
        this.gaA.gaX = i2;
        this.gaA.gaY = i3;
        this.gaA.gaZ = i4;
        this.gaA.gba = i5;
        this.gaA.gbb = i6;
        return this;
    }

    public a lO(boolean z) {
        this.gaA.dBA = z;
        return this;
    }

    public b bIC() {
        return new b(this.gaA);
    }
}
