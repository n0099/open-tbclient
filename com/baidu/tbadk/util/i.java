package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean OA() {
        return OB();
    }

    public static boolean OB() {
        return com.baidu.tbadk.core.util.l.hB() && com.baidu.adp.gif.c.hA();
    }

    public static boolean ih(String str) {
        if (str == null) {
            return false;
        }
        if (ii(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.iR().aO("portrait_cdn_open") != 0) && ij(str);
        }
        return true;
    }

    public static boolean ii(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean ij(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
