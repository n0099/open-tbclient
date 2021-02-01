package com.baidu.tieba.ala.liveroom.i;

import java.util.HashSet;
/* loaded from: classes11.dex */
public class g {
    private static HashSet<Integer> hDx = new HashSet<>();

    public static void vz(int i) {
        if (hDx != null) {
            hDx.add(Integer.valueOf(i));
        }
    }

    public static void vA(int i) {
        if (hDx != null) {
            hDx.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean vB(int i) {
        int i2 = 2913168;
        if (hDx != null) {
            if (!hDx.contains(2913168)) {
                if (hDx.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void cfl() {
        if (hDx != null) {
            hDx.clear();
        }
    }
}
