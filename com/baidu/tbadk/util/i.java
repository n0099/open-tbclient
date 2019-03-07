package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime < 500) {
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }
}
