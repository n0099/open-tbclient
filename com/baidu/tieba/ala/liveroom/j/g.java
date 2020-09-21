package com.baidu.tieba.ala.liveroom.j;

import java.util.HashSet;
/* loaded from: classes4.dex */
public class g {
    private static HashSet<Integer> gCL = new HashSet<>();

    public static void uu(int i) {
        if (gCL != null) {
            gCL.add(Integer.valueOf(i));
        }
    }

    public static void uv(int i) {
        if (gCL != null) {
            gCL.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean uw(int i) {
        int i2 = 2913168;
        if (gCL != null) {
            if (!gCL.contains(2913168)) {
                if (gCL.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void bTk() {
        if (gCL != null) {
            gCL.clear();
        }
    }
}
