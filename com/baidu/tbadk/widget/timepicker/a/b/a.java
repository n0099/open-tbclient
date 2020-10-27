package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes21.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a fEJ = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.fEJ.context = context;
        this.fEJ.fEK = eVar;
    }

    public a a(boolean[] zArr) {
        this.fEJ.fER = zArr;
        return this;
    }

    public a kN(boolean z) {
        this.fEJ.fFy = z;
        return this;
    }

    public a I(ViewGroup viewGroup) {
        this.fEJ.decorView = viewGroup;
        return this;
    }

    public a sx(int i) {
        this.fEJ.fFt = i;
        return this;
    }

    public a sy(int i) {
        this.fEJ.fFx = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.fEJ.fES = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.fEJ.fFl = i;
        this.fEJ.fEM = aVar;
        return this;
    }

    public a an(float f) {
        this.fEJ.lineSpacingMultiplier = f;
        return this;
    }

    public a sz(int i) {
        this.fEJ.dividerColor = i;
        return this;
    }

    public a sA(int i) {
        this.fEJ.backgroundId = i;
        return this;
    }

    public a sB(int i) {
        this.fEJ.textColorCenter = i;
        return this;
    }

    public a sC(int i) {
        this.fEJ.textColorOut = i;
        return this;
    }

    public a c(String str, String str2, String str3, String str4, String str5, String str6) {
        this.fEJ.fEZ = str;
        this.fEJ.fFa = str2;
        this.fEJ.fFb = str3;
        this.fEJ.fFc = str4;
        this.fEJ.fFd = str5;
        this.fEJ.fFe = str6;
        return this;
    }

    public a f(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fEJ.fFf = i;
        this.fEJ.fFg = i2;
        this.fEJ.fFh = i3;
        this.fEJ.fFi = i4;
        this.fEJ.fFj = i5;
        this.fEJ.fFk = i6;
        return this;
    }

    public a kO(boolean z) {
        this.fEJ.isCenterLabel = z;
        return this;
    }

    public b bEm() {
        return new b(this.fEJ);
    }
}
