package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean fgu;
    private boolean fug;

    public e(String str) {
        if (str == null || str.length() != 3 || !str.matches("\\d{1}_\\d{1}")) {
            this.fgu = false;
            this.fug = true;
            return;
        }
        this.fgu = str.substring(0, 1).contains("1");
        this.fug = str.substring(2, 3).contains("1");
    }

    public e(boolean z, boolean z2) {
        this.fgu = z;
        this.fug = z2;
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.fgu ? 1 : 0);
        objArr[1] = Integer.valueOf(this.fug ? 1 : 0);
        return String.format("%s_%s", objArr);
    }

    public boolean bix() {
        return this.fgu;
    }

    public boolean biy() {
        return this.fug;
    }
}
