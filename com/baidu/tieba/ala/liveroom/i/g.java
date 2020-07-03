package com.baidu.tieba.ala.liveroom.i;

import java.util.HashSet;
/* loaded from: classes3.dex */
public class g {
    private static HashSet<Integer> ghH = new HashSet<>();

    public static void rv(int i) {
        if (ghH != null) {
            ghH.add(Integer.valueOf(i));
        }
    }

    public static void rw(int i) {
        if (ghH != null) {
            ghH.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean rx(int i) {
        int i2 = 2913168;
        if (ghH != null) {
            if (!ghH.contains(2913168)) {
                if (ghH.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void bED() {
        if (ghH != null) {
            ghH.clear();
        }
    }
}
