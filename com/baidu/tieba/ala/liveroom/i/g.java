package com.baidu.tieba.ala.liveroom.i;

import java.util.HashSet;
/* loaded from: classes10.dex */
public class g {
    private static HashSet<Integer> hFu = new HashSet<>();

    public static void vB(int i) {
        if (hFu != null) {
            hFu.add(Integer.valueOf(i));
        }
    }

    public static void vC(int i) {
        if (hFu != null) {
            hFu.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean vD(int i) {
        int i2 = 2913168;
        if (hFu != null) {
            if (!hFu.contains(2913168)) {
                if (hFu.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void cfy() {
        if (hFu != null) {
            hFu.clear();
        }
    }
}
