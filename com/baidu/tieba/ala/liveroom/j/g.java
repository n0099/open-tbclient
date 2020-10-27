package com.baidu.tieba.ala.liveroom.j;

import java.util.HashSet;
/* loaded from: classes4.dex */
public class g {
    private static HashSet<Integer> hcR = new HashSet<>();

    public static void vt(int i) {
        if (hcR != null) {
            hcR.add(Integer.valueOf(i));
        }
    }

    public static void vu(int i) {
        if (hcR != null) {
            hcR.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean vv(int i) {
        int i2 = 2913168;
        if (hcR != null) {
            if (!hcR.contains(2913168)) {
                if (hcR.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void bZC() {
        if (hcR != null) {
            hcR.clear();
        }
    }
}
