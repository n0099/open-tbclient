package com.baidu.tieba.im.floatwindow;

import android.view.View;
/* loaded from: classes.dex */
public class j {
    private int aYM;
    private int aYN;
    private int radius;

    public boolean a(j jVar) {
        return ((this.aYM - jVar.aYM) * (this.aYM - jVar.aYM)) + ((this.aYN - jVar.aYN) * (this.aYN - jVar.aYN)) < (this.radius + jVar.radius) * (this.radius + jVar.radius);
    }

    public void H(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int measuredHeight = view.getMeasuredHeight() / 2;
        t(iArr[0] + measuredHeight, iArr[1] + measuredHeight, measuredHeight);
    }

    public void t(int i, int i2, int i3) {
        this.aYM = i;
        this.aYN = i2;
        this.radius = i3;
    }

    public boolean isEmpty() {
        return this.aYM == 0 && this.aYN == 0 && this.radius == 0;
    }
}
