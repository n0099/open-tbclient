package com.baidu.tieba.ala.liveroom.h;

import java.util.HashSet;
/* loaded from: classes3.dex */
public class g {
    private static HashSet<Integer> fUL = new HashSet<>();

    public static void qW(int i) {
        if (fUL != null) {
            fUL.add(Integer.valueOf(i));
        }
    }

    public static void qX(int i) {
        if (fUL != null) {
            fUL.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean qY(int i) {
        int i2 = 2913168;
        if (fUL != null) {
            if (!fUL.contains(2913168)) {
                if (fUL.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void bBw() {
        if (fUL != null) {
            fUL.clear();
        }
    }
}
