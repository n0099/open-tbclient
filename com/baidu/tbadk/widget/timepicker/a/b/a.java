package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a dQu = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.dQu.context = context;
        this.dQu.dQv = eVar;
    }

    public a a(boolean[] zArr) {
        this.dQu.dQC = zArr;
        return this;
    }

    public a ho(boolean z) {
        this.dQu.dRj = z;
        return this;
    }

    public a v(ViewGroup viewGroup) {
        this.dQu.decorView = viewGroup;
        return this;
    }

    public a nA(int i) {
        this.dQu.dRe = i;
        return this;
    }

    public a nB(int i) {
        this.dQu.dRi = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.dQu.dQD = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.dQu.dQW = i;
        this.dQu.dQx = aVar;
        return this;
    }

    public a au(float f) {
        this.dQu.lineSpacingMultiplier = f;
        return this;
    }

    public a nC(int i) {
        this.dQu.dividerColor = i;
        return this;
    }

    public a nD(int i) {
        this.dQu.backgroundId = i;
        return this;
    }

    public a nE(int i) {
        this.dQu.textColorCenter = i;
        return this;
    }

    public a nF(int i) {
        this.dQu.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.dQu.dQK = str;
        this.dQu.dQL = str2;
        this.dQu.dQM = str3;
        this.dQu.dQN = str4;
        this.dQu.dQO = str5;
        this.dQu.dQP = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.dQu.dQQ = i;
        this.dQu.dQR = i2;
        this.dQu.dQS = i3;
        this.dQu.dQT = i4;
        this.dQu.dQU = i5;
        this.dQu.dQV = i6;
        return this;
    }

    public a hp(boolean z) {
        this.dQu.isCenterLabel = z;
        return this;
    }

    public b aUP() {
        return new b(this.dQu);
    }
}
