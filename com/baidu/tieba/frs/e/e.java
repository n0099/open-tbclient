package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean fKW;
    private boolean fKX;
    private boolean fwM;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.fwM = false;
            this.fKW = true;
            return;
        }
        this.fwM = str.substring(0, 1).contains("1");
        this.fKW = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.fKX = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.fwM = z;
        this.fKW = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.fwM ? 1 : 0);
        objArr[1] = Integer.valueOf(this.fKW ? 1 : 0);
        objArr[2] = Integer.valueOf(this.fKX ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bpN() {
        return this.fwM;
    }

    public void kB(boolean z) {
        this.fwM = z;
    }

    public boolean bpO() {
        return this.fKW;
    }

    public void kC(boolean z) {
        this.fKW = z;
    }

    public void kD(boolean z) {
        this.fKX = z;
    }

    public boolean bpP() {
        return this.fKX;
    }
}
