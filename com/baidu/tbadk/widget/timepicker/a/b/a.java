package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a dQv = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.dQv.context = context;
        this.dQv.dQw = eVar;
    }

    public a a(boolean[] zArr) {
        this.dQv.dQD = zArr;
        return this;
    }

    public a ho(boolean z) {
        this.dQv.dRk = z;
        return this;
    }

    public a v(ViewGroup viewGroup) {
        this.dQv.decorView = viewGroup;
        return this;
    }

    public a nA(int i) {
        this.dQv.dRf = i;
        return this;
    }

    public a nB(int i) {
        this.dQv.dRj = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.dQv.dQE = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.dQv.dQX = i;
        this.dQv.dQy = aVar;
        return this;
    }

    public a au(float f) {
        this.dQv.lineSpacingMultiplier = f;
        return this;
    }

    public a nC(int i) {
        this.dQv.dividerColor = i;
        return this;
    }

    public a nD(int i) {
        this.dQv.backgroundId = i;
        return this;
    }

    public a nE(int i) {
        this.dQv.textColorCenter = i;
        return this;
    }

    public a nF(int i) {
        this.dQv.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.dQv.dQL = str;
        this.dQv.dQM = str2;
        this.dQv.dQN = str3;
        this.dQv.dQO = str4;
        this.dQv.dQP = str5;
        this.dQv.dQQ = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.dQv.dQR = i;
        this.dQv.dQS = i2;
        this.dQv.dQT = i3;
        this.dQv.dQU = i4;
        this.dQv.dQV = i5;
        this.dQv.dQW = i6;
        return this;
    }

    public a hp(boolean z) {
        this.dQv.isCenterLabel = z;
        return this;
    }

    public b aUR() {
        return new b(this.dQv);
    }
}
