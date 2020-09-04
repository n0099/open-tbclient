package com.baidu.tieba.ala.liveroom.j;

import java.util.HashSet;
/* loaded from: classes7.dex */
public class g {
    private static HashSet<Integer> gzA = new HashSet<>();

    public static void ub(int i) {
        if (gzA != null) {
            gzA.add(Integer.valueOf(i));
        }
    }

    public static void uc(int i) {
        if (gzA != null) {
            gzA.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean ud(int i) {
        int i2 = 2913168;
        if (gzA != null) {
            if (!gzA.contains(2913168)) {
                if (gzA.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void bRO() {
        if (gzA != null) {
            gzA.clear();
        }
    }
}
