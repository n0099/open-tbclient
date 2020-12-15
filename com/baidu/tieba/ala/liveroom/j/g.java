package com.baidu.tieba.ala.liveroom.j;

import java.util.HashSet;
/* loaded from: classes4.dex */
public class g {
    private static HashSet<Integer> hrX = new HashSet<>();

    public static void wJ(int i) {
        if (hrX != null) {
            hrX.add(Integer.valueOf(i));
        }
    }

    public static void wK(int i) {
        if (hrX != null) {
            hrX.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean wL(int i) {
        int i2 = 2913168;
        if (hrX != null) {
            if (!hrX.contains(2913168)) {
                if (hrX.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void cfr() {
        if (hrX != null) {
            hrX.clear();
        }
    }
}
