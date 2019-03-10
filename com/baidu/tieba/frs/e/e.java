package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean fgJ;
    private boolean fuv;

    public e(String str) {
        if (str == null || str.length() != 3 || !str.matches("\\d{1}_\\d{1}")) {
            this.fgJ = false;
            this.fuv = true;
            return;
        }
        this.fgJ = str.substring(0, 1).contains("1");
        this.fuv = str.substring(2, 3).contains("1");
    }

    public e(boolean z, boolean z2) {
        this.fgJ = z;
        this.fuv = z2;
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.fgJ ? 1 : 0);
        objArr[1] = Integer.valueOf(this.fuv ? 1 : 0);
        return String.format("%s_%s", objArr);
    }

    public boolean biA() {
        return this.fgJ;
    }

    public boolean biB() {
        return this.fuv;
    }
}
