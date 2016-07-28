package com.baidu.tbadk.util;

import android.text.TextUtils;
import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class v {
    public static boolean e(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || ((c >= '0' && c <= '9') || c == ' ');
    }

    public static int gw(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            if (e(str.charAt(i2))) {
                i++;
            } else {
                i += 2;
            }
        }
        return i;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r2v0 int)] */
    public static String eW(int i) {
        if (i >= 100000000) {
            return String.valueOf(i / 100000000) + "亿+";
        }
        if (i >= 10000) {
            return String.valueOf(i / 10000) + "万+";
        }
        return new StringBuilder().append(i).toString();
    }

    public static String G(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (gw(str) > i) {
            return String.valueOf(d(str, 0, i - 2)) + "...";
        }
        return str;
    }

    public static String H(String str, int i) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        if (gw(str) > i) {
            return d(str, 0, i);
        }
        return str;
    }

    public static String d(String str, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str) || i > i2) {
            return sb.toString();
        }
        if (i >= 0 && i2 >= 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < str.length(); i4++) {
                char charAt = str.charAt(i4);
                if (i3 >= i2) {
                    if (i3 == i2) {
                        return sb.toString();
                    }
                    return sb.deleteCharAt(sb.length() - 1).toString();
                }
                if (i3 >= i) {
                    sb.append(charAt);
                }
                if (e(charAt)) {
                    i3++;
                } else {
                    i3 += 2;
                }
            }
        }
        return sb.toString();
    }

    public static boolean f(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == ' ';
    }

    public static String I(String str, int i) {
        StringBuilder sb = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            return sb.toString();
        }
        if (i > 0) {
            int i2 = 0;
            for (int i3 = 0; i3 < str.length(); i3++) {
                char charAt = str.charAt(i3);
                if (i2 >= i) {
                    if (i2 == i) {
                        return sb.toString();
                    }
                    return sb.deleteCharAt(sb.length() - 1).toString();
                }
                if (i2 >= 0) {
                    sb.append(charAt);
                }
                if (f(charAt)) {
                    i2++;
                } else {
                    i2 += 2;
                }
            }
        }
        return sb.toString();
    }
}
