package com.baidu.tieba.ala.liveroom.h;

import java.util.HashSet;
/* loaded from: classes3.dex */
public class g {
    private static HashSet<Integer> fGA = new HashSet<>();

    public static void qt(int i) {
        if (fGA != null) {
            fGA.add(Integer.valueOf(i));
        }
    }

    public static void qu(int i) {
        if (fGA != null) {
            fGA.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean qv(int i) {
        int i2 = 2913168;
        if (fGA != null) {
            if (!fGA.contains(2913168)) {
                if (fGA.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void bvx() {
        if (fGA != null) {
            fGA.clear();
        }
    }
}
