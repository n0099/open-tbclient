package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean fBJ;
    private boolean fPX;
    private boolean fPY;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.fBJ = false;
            this.fPX = true;
            return;
        }
        this.fBJ = str.substring(0, 1).contains("1");
        this.fPX = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.fPY = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.fBJ = z;
        this.fPX = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.fBJ ? 1 : 0);
        objArr[1] = Integer.valueOf(this.fPX ? 1 : 0);
        objArr[2] = Integer.valueOf(this.fPY ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean brT() {
        return this.fBJ;
    }

    public void kM(boolean z) {
        this.fBJ = z;
    }

    public boolean brU() {
        return this.fPX;
    }

    public void kN(boolean z) {
        this.fPX = z;
    }

    public void kO(boolean z) {
        this.fPY = z;
    }

    public boolean brV() {
        return this.fPY;
    }
}
