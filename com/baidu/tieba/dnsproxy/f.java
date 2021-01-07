package com.baidu.tieba.dnsproxy;
/* loaded from: classes8.dex */
public class f {
    private static f iDB = null;

    public static final f cwN() {
        if (iDB == null) {
            synchronized (f.class) {
                if (iDB == null) {
                    iDB = new f();
                }
            }
        }
        return iDB;
    }

    private f() {
    }

    public boolean Jy(String str) {
        return true;
    }

    public boolean Jz(String str) {
        return false;
    }
}
