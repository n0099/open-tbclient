package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes21.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a fwo = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.fwo.context = context;
        this.fwo.fwp = eVar;
    }

    public a a(boolean[] zArr) {
        this.fwo.fww = zArr;
        return this;
    }

    public a kA(boolean z) {
        this.fwo.fxd = z;
        return this;
    }

    public a H(ViewGroup viewGroup) {
        this.fwo.decorView = viewGroup;
        return this;
    }

    public a sm(int i) {
        this.fwo.fwY = i;
        return this;
    }

    public a sn(int i) {
        this.fwo.fxc = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.fwo.fwx = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.fwo.fwQ = i;
        this.fwo.fwr = aVar;
        return this;
    }

    public a al(float f) {
        this.fwo.lineSpacingMultiplier = f;
        return this;
    }

    public a so(int i) {
        this.fwo.dividerColor = i;
        return this;
    }

    public a sp(int i) {
        this.fwo.backgroundId = i;
        return this;
    }

    public a sq(int i) {
        this.fwo.textColorCenter = i;
        return this;
    }

    public a sr(int i) {
        this.fwo.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.fwo.fwE = str;
        this.fwo.fwF = str2;
        this.fwo.fwG = str3;
        this.fwo.fwH = str4;
        this.fwo.fwI = str5;
        this.fwo.fwJ = str6;
        return this;
    }

    public a f(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fwo.fwK = i;
        this.fwo.fwL = i2;
        this.fwo.fwM = i3;
        this.fwo.fwN = i4;
        this.fwo.fwO = i5;
        this.fwo.fwP = i6;
        return this;
    }

    public a kB(boolean z) {
        this.fwo.isCenterLabel = z;
        return this;
    }

    public b bCt() {
        return new b(this.fwo);
    }
}
