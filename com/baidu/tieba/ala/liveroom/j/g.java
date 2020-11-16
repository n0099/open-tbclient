package com.baidu.tieba.ala.liveroom.j;

import java.util.HashSet;
/* loaded from: classes4.dex */
public class g {
    private static HashSet<Integer> hiu = new HashSet<>();

    public static void we(int i) {
        if (hiu != null) {
            hiu.add(Integer.valueOf(i));
        }
    }

    public static void wf(int i) {
        if (hiu != null) {
            hiu.remove(Integer.valueOf(i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean wg(int i) {
        int i2 = 2913168;
        if (hiu != null) {
            if (!hiu.contains(2913168)) {
                if (hiu.contains(2913128)) {
                    i2 = 2913128;
                }
            }
            return i != i2;
        }
        i2 = -1;
        if (i != i2) {
        }
    }

    public static void cbx() {
        if (hiu != null) {
            hiu.clear();
        }
    }
}
