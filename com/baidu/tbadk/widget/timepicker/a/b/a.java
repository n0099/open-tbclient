package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a fYZ = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.fYZ.context = context;
        this.fYZ.fZa = eVar;
    }

    public a a(boolean[] zArr) {
        this.fYZ.fZh = zArr;
        return this;
    }

    public a lN(boolean z) {
        this.fYZ.fZO = z;
        return this;
    }

    public a L(ViewGroup viewGroup) {
        this.fYZ.decorView = viewGroup;
        return this;
    }

    public a ss(int i) {
        this.fYZ.fZJ = i;
        return this;
    }

    public a st(int i) {
        this.fYZ.fZN = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.fYZ.fZi = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.fYZ.fZB = i;
        this.fYZ.fZc = aVar;
        return this;
    }

    public a av(float f) {
        this.fYZ.dAp = f;
        return this;
    }

    public a su(int i) {
        this.fYZ.dAo = i;
        return this;
    }

    public a sv(int i) {
        this.fYZ.backgroundId = i;
        return this;
    }

    public a sw(int i) {
        this.fYZ.dAn = i;
        return this;
    }

    public a sx(int i) {
        this.fYZ.dAm = i;
        return this;
    }

    public a d(String str, String str2, String str3, String str4, String str5, String str6) {
        this.fYZ.fZp = str;
        this.fYZ.fZq = str2;
        this.fYZ.fZr = str3;
        this.fYZ.fZs = str4;
        this.fYZ.fZt = str5;
        this.fYZ.fZu = str6;
        return this;
    }

    public a h(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fYZ.fZv = i;
        this.fYZ.fZw = i2;
        this.fYZ.fZx = i3;
        this.fYZ.fZy = i4;
        this.fYZ.fZz = i5;
        this.fYZ.fZA = i6;
        return this;
    }

    public a lO(boolean z) {
        this.fYZ.dzZ = z;
        return this;
    }

    public b bIy() {
        return new b(this.fYZ);
    }
}
