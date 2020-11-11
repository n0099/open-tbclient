package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean iQQ;
    private boolean jgW;
    private boolean jgX;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.iQQ = false;
            this.jgW = true;
            return;
        }
        this.iQQ = str.substring(0, 1).contains("1");
        this.jgW = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.jgX = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.iQQ = z;
        this.jgW = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.iQQ ? 1 : 0);
        objArr[1] = Integer.valueOf(this.jgW ? 1 : 0);
        objArr[2] = Integer.valueOf(this.jgX ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean cFc() {
        return this.iQQ;
    }

    public void qp(boolean z) {
        this.iQQ = z;
    }

    public boolean cFd() {
        return this.jgW;
    }

    public void qq(boolean z) {
        this.jgW = z;
    }

    public void qr(boolean z) {
        this.jgX = z;
    }

    public boolean cFe() {
        return this.jgX;
    }
}
