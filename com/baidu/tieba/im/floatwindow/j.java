package com.baidu.tieba.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class j {
    private int aXr;
    private int aXs;
    private int radius;

    public boolean a(j jVar) {
        return ((this.aXr - jVar.aXr) * (this.aXr - jVar.aXr)) + ((this.aXs - jVar.aXs) * (this.aXs - jVar.aXs)) < (this.radius + jVar.radius) * (this.radius + jVar.radius);
    }

    public void F(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void t(int i, int i2, int i3) {
        this.aXr = i;
        this.aXs = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.aXr == 0 && this.aXs == 0 && this.radius == 0;
    }
}
