package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean hgs;
    private boolean hvu;
    private boolean hvv;

    public e(String str) {
        if (str == null || !str.matches("\\d{1}_\\d{1}.*")) {
            this.hgs = false;
            this.hvu = true;
            return;
        }
        this.hgs = str.substring(0, 1).contains("1");
        this.hvu = str.substring(2, 3).contains("1");
        if (str.length() >= 5) {
            this.hvv = str.substring(4, 5).contains("1");
        }
    }

    public e(boolean z, boolean z2) {
        this.hgs = z;
        this.hvu = z2;
    }

    public String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.hgs ? 1 : 0);
        objArr[1] = Integer.valueOf(this.hvu ? 1 : 0);
        objArr[2] = Integer.valueOf(this.hvv ? 1 : 0);
        return String.format("%s_%s_%s", objArr);
    }

    public boolean bUG() {
        return this.hgs;
    }

    public void nl(boolean z) {
        this.hgs = z;
    }

    public boolean bUH() {
        return this.hvu;
    }

    public void nm(boolean z) {
        this.hvu = z;
    }

    public void nn(boolean z) {
        this.hvv = z;
    }

    public boolean bUI() {
        return this.hvv;
    }
}
