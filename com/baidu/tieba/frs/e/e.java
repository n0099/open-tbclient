package com.baidu.tieba.frs.e;
/* loaded from: classes.dex */
public class e {
    private boolean fgI;
    private boolean fuu;

    public e(String str) {
        if (str == null || str.length() != 3 || !str.matches("\\d{1}_\\d{1}")) {
            this.fgI = false;
            this.fuu = true;
            return;
        }
        this.fgI = str.substring(0, 1).contains("1");
        this.fuu = str.substring(2, 3).contains("1");
    }

    public e(boolean z, boolean z2) {
        this.fgI = z;
        this.fuu = z2;
    }

    public String toString() {
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(this.fgI ? 1 : 0);
        objArr[1] = Integer.valueOf(this.fuu ? 1 : 0);
        return String.format("%s_%s", objArr);
    }

    public boolean biz() {
        return this.fgI;
    }

    public boolean biA() {
        return this.fuu;
    }
}
