package com.baidu.tieba.frs.c;
/* loaded from: classes.dex */
public class e {
    private boolean jIT;
    private boolean jIU;
    private boolean jqd;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.jqd = false;
            this.jIT = true;
            return;
        }
        this.jqd = str.substring(0, 1).contains("1");
        this.jIT = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.jIU = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.jqd = z;
        this.jIT = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.jqd ? 1 : 0);
        objArr[1] = Integer.valueOf(this.jIT ? 1 : 0);
        objArr[2] = Integer.valueOf(this.jIU ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cKz() {
        return this.jqd;
    }

    public void rx(boolean z) {
        this.jqd = z;
    }

    public boolean cKA() {
        return this.jIT;
    }

    public void ry(boolean z) {
        this.jIT = z;
    }

    public void rz(boolean z) {
        this.jIU = z;
    }

    public boolean cKB() {
        return this.jIU;
    }
}
