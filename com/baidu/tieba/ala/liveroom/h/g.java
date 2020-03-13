package com.baidu.tieba.ala.liveroom.h;

import java.util.HashSet;
/* loaded from: classes3.dex */
public class g {
    private static HashSet<Integer> fbT = new HashSet<>();

    public static void pY(int i) {
        if (fbT != null) {
            fbT.add(Integer.valueOf(i));
        }
    }

    public static void pZ(int i) {
        if (fbT != null) {
            fbT.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean qa(int i) {
        int i2 = 2913168;
        if (fbT != null) {
            if (!fbT.contains(2913168)) {
                if (fbT.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void bmc() {
        if (fbT != null) {
            fbT.clear();
        }
    }
}
