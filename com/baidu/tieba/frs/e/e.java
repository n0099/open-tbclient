package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean fEk;
    private boolean fSC;
    private boolean fSD;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.fEk = false;
            this.fSC = true;
            return;
        }
        this.fEk = str.substring(0, 1).contains("1");
        this.fSC = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.fSD = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.fEk = z;
        this.fSC = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.fEk ? 1 : 0);
        objArr[1] = Integer.valueOf(this.fSC ? 1 : 0);
        objArr[2] = Integer.valueOf(this.fSD ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bsT() {
        return this.fEk;
    }

    public void kP(boolean z) {
        this.fEk = z;
    }

    public boolean bsU() {
        return this.fSC;
    }

    public void kQ(boolean z) {
        this.fSC = z;
    }

    public void kR(boolean z) {
        this.fSD = z;
    }

    public boolean bsV() {
        return this.fSD;
    }
}
