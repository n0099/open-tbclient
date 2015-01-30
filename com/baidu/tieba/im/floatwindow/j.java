package com.baidu.tieba.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class j {
    private int aYN;
    private int aYO;
    private int radius;

    public boolean a(j jVar) {
        return ((this.aYN - jVar.aYN) * (this.aYN - jVar.aYN)) + ((this.aYO - jVar.aYO) * (this.aYO - jVar.aYO)) < (this.radius + jVar.radius) * (this.radius + jVar.radius);
    }

    public void H(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void t(int i, int i2, int i3) {
        this.aYN = i;
        this.aYO = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.aYN == 0 && this.aYO == 0 && this.radius == 0;
    }
}
