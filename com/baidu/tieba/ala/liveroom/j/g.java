package com.baidu.tieba.ala.liveroom.j;

import java.util.HashSet;
/* loaded from: classes4.dex */
public class g {
    private static HashSet<Integer> gRe = new HashSet<>();

    public static void uZ(int i) {
        if (gRe != null) {
            gRe.add(Integer.valueOf(i));
        }
    }

    public static void va(int i) {
        if (gRe != null) {
            gRe.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean vb(int i) {
        int i2 = 2913168;
        if (gRe != null) {
            if (!gRe.contains(2913168)) {
                if (gRe.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void bWD() {
        if (gRe != null) {
            gRe.clear();
        }
    }
}
