package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean fDB;
    private boolean fRV;
    private boolean fRW;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.fDB = false;
            this.fRV = true;
            return;
        }
        this.fDB = str.substring(0, 1).contains("1");
        this.fRV = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.fRW = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.fDB = z;
        this.fRV = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.fDB ? 1 : 0);
        objArr[1] = Integer.valueOf(this.fRV ? 1 : 0);
        objArr[2] = Integer.valueOf(this.fRW ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bpX() {
        return this.fDB;
    }

    public void kC(boolean z) {
        this.fDB = z;
    }

    public boolean bpY() {
        return this.fRV;
    }

    public void kD(boolean z) {
        this.fRV = z;
    }

    public void kE(boolean z) {
        this.fRW = z;
    }

    public boolean bpZ() {
        return this.fRW;
    }
}
