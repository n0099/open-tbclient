package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean jcv;
    private boolean jvk;
    private boolean jvl;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.jcv = false;
            this.jvk = true;
            return;
        }
        this.jcv = str.substring(0, 1).contains("1");
        this.jvk = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.jvl = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.jcv = z;
        this.jvk = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.jcv ? 1 : 0);
        objArr[1] = Integer.valueOf(this.jvk ? 1 : 0);
        objArr[2] = Integer.valueOf(this.jvl ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cJU() {
        return this.jcv;
    }

    public void qT(boolean z) {
        this.jcv = z;
    }

    public boolean cJV() {
        return this.jvk;
    }

    public void qU(boolean z) {
        this.jvk = z;
    }

    public void qV(boolean z) {
        this.jvl = z;
    }

    public boolean cJW() {
        return this.jvl;
    }
}
