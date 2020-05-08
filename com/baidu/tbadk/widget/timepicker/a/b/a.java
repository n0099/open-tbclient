package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a erb = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.erb.context = context;
        this.erb.erc = eVar;
    }

    public a a(boolean[] zArr) {
        this.erb.erj = zArr;
        return this;
    }

    public a in(boolean z) {
        this.erb.erR = z;
        return this;
    }

    public a w(ViewGroup viewGroup) {
        this.erb.decorView = viewGroup;
        return this;
    }

    public a nP(int i) {
        this.erb.erM = i;
        return this;
    }

    public a nQ(int i) {
        this.erb.erQ = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.erb.erk = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.erb.erE = i;
        this.erb.ere = aVar;
        return this;
    }

    public a ae(float f) {
        this.erb.lineSpacingMultiplier = f;
        return this;
    }

    public a nR(int i) {
        this.erb.dividerColor = i;
        return this;
    }

    public a nS(int i) {
        this.erb.backgroundId = i;
        return this;
    }

    public a nT(int i) {
        this.erb.textColorCenter = i;
        return this;
    }

    public a nU(int i) {
        this.erb.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.erb.ers = str;
        this.erb.ert = str2;
        this.erb.eru = str3;
        this.erb.erv = str4;
        this.erb.erw = str5;
        this.erb.erx = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.erb.ery = i;
        this.erb.erz = i2;
        this.erb.erA = i3;
        this.erb.erB = i4;
        this.erb.erC = i5;
        this.erb.erD = i6;
        return this;
    }

    public a io(boolean z) {
        this.erb.isCenterLabel = z;
        return this;
    }

    public b bde() {
        return new b(this.erb);
    }
}
