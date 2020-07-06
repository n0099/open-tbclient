package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes8.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a ePZ = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.ePZ.context = context;
        this.ePZ.eQa = eVar;
    }

    public a a(boolean[] zArr) {
        this.ePZ.eQh = zArr;
        return this;
    }

    public a iW(boolean z) {
        this.ePZ.eQO = z;
        return this;
    }

    public a C(ViewGroup viewGroup) {
        this.ePZ.decorView = viewGroup;
        return this;
    }

    public a oU(int i) {
        this.ePZ.eQJ = i;
        return this;
    }

    public a oV(int i) {
        this.ePZ.eQN = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.ePZ.eQi = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.ePZ.eQB = i;
        this.ePZ.eQc = aVar;
        return this;
    }

    public a ae(float f) {
        this.ePZ.lineSpacingMultiplier = f;
        return this;
    }

    public a oW(int i) {
        this.ePZ.dividerColor = i;
        return this;
    }

    public a oX(int i) {
        this.ePZ.backgroundId = i;
        return this;
    }

    public a oY(int i) {
        this.ePZ.textColorCenter = i;
        return this;
    }

    public a oZ(int i) {
        this.ePZ.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.ePZ.eQp = str;
        this.ePZ.eQq = str2;
        this.ePZ.eQr = str3;
        this.ePZ.eQs = str4;
        this.ePZ.eQt = str5;
        this.ePZ.eQu = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.ePZ.eQv = i;
        this.ePZ.eQw = i2;
        this.ePZ.eQx = i3;
        this.ePZ.eQy = i4;
        this.ePZ.eQz = i5;
        this.ePZ.eQA = i6;
        return this;
    }

    public a iX(boolean z) {
        this.ePZ.isCenterLabel = z;
        return this;
    }

    public b blR() {
        return new b(this.ePZ);
    }
}
