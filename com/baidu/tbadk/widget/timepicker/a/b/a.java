package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a bke = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.bke.context = context;
        this.bke.bkf = eVar;
    }

    public a b(boolean[] zArr) {
        this.bke.bkm = zArr;
        return this;
    }

    public a gp(int i) {
        this.bke.bkM = i;
        return this;
    }

    public a gq(int i) {
        this.bke.bkQ = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.bke.bkn = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.bke.bkE = i;
        this.bke.bkh = aVar;
        return this;
    }

    public a ad(float f) {
        this.bke.bkU = f;
        return this;
    }

    public a gr(int i) {
        this.bke.bkT = i;
        return this;
    }

    public a gs(int i) {
        this.bke.aVb = i;
        return this;
    }

    public a gt(int i) {
        this.bke.bkS = i;
        return this;
    }

    public a gu(int i) {
        this.bke.bkR = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.bke.bks = str;
        this.bke.bkt = str2;
        this.bke.bku = str3;
        this.bke.bkv = str4;
        this.bke.bkw = str5;
        this.bke.bkx = str6;
        return this;
    }

    public a d(int i, int i2, int i3, int i4, int i5, int i6) {
        this.bke.bky = i;
        this.bke.bkz = i2;
        this.bke.bkA = i3;
        this.bke.bkB = i4;
        this.bke.bkC = i5;
        this.bke.bkD = i6;
        return this;
    }

    public a cB(boolean z) {
        this.bke.bkX = z;
        return this;
    }

    public b PN() {
        return new b(this.bke);
    }
}
