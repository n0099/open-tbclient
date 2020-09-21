package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean ijA;
    private boolean izK;
    private boolean izL;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.ijA = false;
            this.izK = true;
            return;
        }
        this.ijA = str.substring(0, 1).contains("1");
        this.izK = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.izL = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.ijA = z;
        this.izK = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.ijA ? 1 : 0);
        objArr[1] = Integer.valueOf(this.izK ? 1 : 0);
        objArr[2] = Integer.valueOf(this.izL ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cvX() {
        return this.ijA;
    }

    public void pj(boolean z) {
        this.ijA = z;
    }

    public boolean cvY() {
        return this.izK;
    }

    public void pk(boolean z) {
        this.izK = z;
    }

    public void pl(boolean z) {
        this.izL = z;
    }

    public boolean cvZ() {
        return this.izL;
    }
}
