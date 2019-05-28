package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean fKX;
    private boolean fKY;
    private boolean fwN;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.fwN = false;
            this.fKX = true;
            return;
        }
        this.fwN = str.substring(0, 1).contains("1");
        this.fKX = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.fKY = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.fwN = z;
        this.fKX = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.fwN ? 1 : 0);
        objArr[1] = Integer.valueOf(this.fKX ? 1 : 0);
        objArr[2] = Integer.valueOf(this.fKY ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bpQ() {
        return this.fwN;
    }

    public void kB(boolean z) {
        this.fwN = z;
    }

    public boolean bpR() {
        return this.fKX;
    }

    public void kC(boolean z) {
        this.fKX = z;
    }

    public void kD(boolean z) {
        this.fKY = z;
    }

    public boolean bpS() {
        return this.fKY;
    }
}
