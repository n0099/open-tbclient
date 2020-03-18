package com.baidu.tieba.ala.liveroom.h;

import java.util.HashSet;
/* loaded from: classes3.dex */
public class g {
    private static HashSet<Integer> fcr = new HashSet<>();

    public static void qa(int i) {
        if (fcr != null) {
            fcr.add(Integer.valueOf(i));
        }
    }

    public static void qb(int i) {
        if (fcr != null) {
            fcr.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean qc(int i) {
        int i2 = 2913168;
        if (fcr != null) {
            if (!fcr.contains(2913168)) {
                if (fcr.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void bmh() {
        if (fcr != null) {
            fcr.clear();
        }
    }
}
