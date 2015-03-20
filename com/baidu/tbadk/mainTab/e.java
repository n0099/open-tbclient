package com.baidu.tbadk.mainTab;
/* loaded from: classes.dex */
public abstract class e {
    private int alX;
    private boolean alY;

    public abstract void onClick();

    public void aR(boolean z) {
        this.alY = z;
    }

    public void dH(int i) {
        this.alX = i;
    }

    public int zM() {
        return this.alX;
    }
}
