package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean gLW;
    private boolean gLX;
    private boolean gxc;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.gxc = false;
            this.gLW = true;
            return;
        }
        this.gxc = str.substring(0, 1).contains("1");
        this.gLW = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.gLX = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.gxc = z;
        this.gLW = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.gxc ? 1 : 0);
        objArr[1] = Integer.valueOf(this.gLW ? 1 : 0);
        objArr[2] = Integer.valueOf(this.gLX ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bKk() {
        return this.gxc;
    }

    public void mh(boolean z) {
        this.gxc = z;
    }

    public boolean bKl() {
        return this.gLW;
    }

    public void mi(boolean z) {
        this.gLW = z;
    }

    public void mj(boolean z) {
        this.gLX = z;
    }

    public boolean bKm() {
        return this.gLX;
    }
}
