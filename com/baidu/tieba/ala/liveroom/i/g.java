package com.baidu.tieba.ala.liveroom.i;

import java.util.HashSet;
/* loaded from: classes2.dex */
public class g {
    private static HashSet<Integer> eXW = new HashSet<>();

    public static void pQ(int i) {
        if (eXW != null) {
            eXW.add(Integer.valueOf(i));
        }
    }

    public static void pR(int i) {
        if (eXW != null) {
            eXW.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean pS(int i) {
        int i2 = 2913151;
        if (eXW != null) {
            if (!eXW.contains(2913151)) {
                if (eXW.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void bkl() {
        if (eXW != null) {
            eXW.clear();
        }
    }
}
