package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean jcx;
    private boolean jvm;
    private boolean jvn;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.jcx = false;
            this.jvm = true;
            return;
        }
        this.jcx = str.substring(0, 1).contains("1");
        this.jvm = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.jvn = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.jcx = z;
        this.jvm = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.jcx ? 1 : 0);
        objArr[1] = Integer.valueOf(this.jvm ? 1 : 0);
        objArr[2] = Integer.valueOf(this.jvn ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cJV() {
        return this.jcx;
    }

    public void qT(boolean z) {
        this.jcx = z;
    }

    public boolean cJW() {
        return this.jvm;
    }

    public void qU(boolean z) {
        this.jvm = z;
    }

    public void qV(boolean z) {
        this.jvn = z;
    }

    public boolean cJX() {
        return this.jvn;
    }
}
