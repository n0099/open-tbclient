package com.baidu.tieba.frs.c;
/* loaded from: classes.dex */
public class e {
    private boolean jHH;
    private boolean jHI;
    private boolean joP;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.joP = false;
            this.jHH = true;
            return;
        }
        this.joP = str.substring(0, 1).contains("1");
        this.jHH = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.jHI = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.joP = z;
        this.jHH = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.joP ? 1 : 0);
        objArr[1] = Integer.valueOf(this.jHH ? 1 : 0);
        objArr[2] = Integer.valueOf(this.jHI ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cMW() {
        return this.joP;
    }

    public void rr(boolean z) {
        this.joP = z;
    }

    public boolean cMX() {
        return this.jHH;
    }

    public void rs(boolean z) {
        this.jHH = z;
    }

    public void rt(boolean z) {
        this.jHI = z;
    }

    public boolean cMY() {
        return this.jHI;
    }
}
