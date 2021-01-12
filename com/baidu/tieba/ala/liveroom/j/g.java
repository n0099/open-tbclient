package com.baidu.tieba.ala.liveroom.j;

import java.util.HashSet;
/* loaded from: classes10.dex */
public class g {
    private static HashSet<Integer> hzm = new HashSet<>();

    public static void vo(int i) {
        if (hzm != null) {
            hzm.add(Integer.valueOf(i));
        }
    }

    public static void vp(int i) {
        if (hzm != null) {
            hzm.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean vq(int i) {
        int i2 = 2913168;
        if (hzm != null) {
            if (!hzm.contains(2913168)) {
                if (hzm.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void ceq() {
        if (hzm != null) {
            hzm.clear();
        }
    }
}
