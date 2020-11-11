package com.baidu.tieba.dnsproxy;
/* loaded from: classes13.dex */
public class f {
    private static f ifD = null;

    public static final f cqd() {
        if (ifD == null) {
            synchronized (f.class) {
                if (ifD == null) {
                    ifD = new f();
                }
            }
        }
        return ifD;
    }

    private f() {
    }

    public boolean Jk(String str) {
        return true;
    }

    public boolean Jl(String str) {
        return false;
    }
}
