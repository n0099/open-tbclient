package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class d {
    public static boolean EB() {
        return EC();
    }

    public static boolean EC() {
        return com.baidu.tbadk.core.util.n.fl() && com.baidu.adp.gif.e.fk();
    }

    public static boolean fw(String str) {
        if (str == null) {
            return false;
        }
        if (fx(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.e.gy().ah("portrait_cdn_open") != 0) && fy(str);
        }
        return true;
    }

    public static boolean fx(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean fy(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
