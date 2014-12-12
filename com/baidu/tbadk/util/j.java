package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class j {
    public static boolean b(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == ' ');
    }

    public static int eI(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (b(str.charAt(i2))) {
                i++;
            } else {
                i += 2;
            }
        }
        return i;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public static String dV(int i) {
        if (i >= 100000000) {
            return String.valueOf(i / 100000000) + "亿+";
        }
        if (i >= 10000) {
            return String.valueOf(i / TbConfig.BIG_IMAGE_MIN_CAPACITY) + "万+";
        }
        return new StringBuilder().append(i).toString();
    }

    public static String f(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str) || i > i2) {
            return sb.toString();
        }
        if (i >= 0 && i2 >= 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < str.length(); i4++) {
                char charAt = str.charAt(i4);
                if (i3 >= i2) {
                    return sb.toString();
                }
                if (i3 >= i) {
                    sb.append(charAt);
                }
                if (b(charAt)) {
                    i3++;
                } else {
                    i3 += 2;
                }
            }
        }
        return sb.toString();
    }
}
