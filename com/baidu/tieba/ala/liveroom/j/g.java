package com.baidu.tieba.ala.liveroom.j;

import java.util.HashSet;
/* loaded from: classes11.dex */
public class g {
    private static HashSet<Integer> hDS = new HashSet<>();

    public static void wU(int i) {
        if (hDS != null) {
            hDS.add(Integer.valueOf(i));
        }
    }

    public static void wV(int i) {
        if (hDS != null) {
            hDS.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean wW(int i) {
        int i2 = 2913168;
        if (hDS != null) {
            if (!hDS.contains(2913168)) {
                if (hDS.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void cih() {
        if (hDS != null) {
            hDS.clear();
        }
    }
}
