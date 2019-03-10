package com.baidu.tbadk.u;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
public class a {
    public static String pU(String str) {
        if (StringUtils.isNull(str)) {
            return null;
        }
        int indexOf = str.indexOf("(");
        int indexOf2 = str.indexOf(")");
        if (indexOf == -1 || indexOf2 == -1 || indexOf + 1 >= indexOf2) {
            return null;
        }
        return str.substring(indexOf + 1, indexOf2);
    }

    public static boolean pV(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        return str.equals("4") || str.equals("5");
    }
}
