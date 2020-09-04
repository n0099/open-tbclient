package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class k {
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (lastClickTime > currentTimeMillis) {
            lastClickTime = currentTimeMillis;
            return false;
        } else if (currentTimeMillis - lastClickTime < 500) {
            return true;
        } else {
            lastClickTime = currentTimeMillis;
            return false;
        }
    }
}
