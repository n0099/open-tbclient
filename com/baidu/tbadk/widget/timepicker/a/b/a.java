package com.baidu.tbadk.widget.timepicker.a.b;

import android.content.Context;
import android.view.ViewGroup;
import com.baidu.tbadk.widget.timepicker.a.d.e;
import com.baidu.tbadk.widget.timepicker.a.f.b;
import java.util.Calendar;
/* loaded from: classes15.dex */
public class a {
    private com.baidu.tbadk.widget.timepicker.a.c.a eWu = new com.baidu.tbadk.widget.timepicker.a.c.a(2);

    public a(Context context, e eVar) {
        this.eWu.context = context;
        this.eWu.eWv = eVar;
    }

    public a a(boolean[] zArr) {
        this.eWu.eWC = zArr;
        return this;
    }

    public a jB(boolean z) {
        this.eWu.eXj = z;
        return this;
    }

    public a D(ViewGroup viewGroup) {
        this.eWu.decorView = viewGroup;
        return this;
    }

    public a pl(int i) {
        this.eWu.eXe = i;
        return this;
    }

    public a pm(int i) {
        this.eWu.eXi = i;
        return this;
    }

    public a a(Calendar calendar) {
        this.eWu.eWD = calendar;
        return this;
    }

    public a a(int i, com.baidu.tbadk.widget.timepicker.a.d.a aVar) {
        this.eWu.eWW = i;
        this.eWu.eWx = aVar;
        return this;
    }

    public a ae(float f) {
        this.eWu.lineSpacingMultiplier = f;
        return this;
    }

    public a po(int i) {
        this.eWu.dividerColor = i;
        return this;
    }

    public a pp(int i) {
        this.eWu.backgroundId = i;
        return this;
    }

    public a pq(int i) {
        this.eWu.textColorCenter = i;
        return this;
    }

    public a pr(int i) {
        this.eWu.textColorOut = i;
        return this;
    }

    public a b(String str, String str2, String str3, String str4, String str5, String str6) {
        this.eWu.eWK = str;
        this.eWu.eWL = str2;
        this.eWu.eWM = str3;
        this.eWu.eWN = str4;
        this.eWu.eWO = str5;
        this.eWu.eWP = str6;
        return this;
    }

    public a g(int i, int i2, int i3, int i4, int i5, int i6) {
        this.eWu.eWQ = i;
        this.eWu.eWR = i2;
        this.eWu.eWS = i3;
        this.eWu.eWT = i4;
        this.eWu.eWU = i5;
        this.eWu.eWV = i6;
        return this;
    }

    public a jC(boolean z) {
        this.eWu.isCenterLabel = z;
        return this;
    }

    public b bpL() {
        return new b(this.eWu);
    }
}
