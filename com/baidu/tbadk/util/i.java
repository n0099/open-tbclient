package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean OJ() {
        return OK();
    }

    public static boolean OK() {
        return com.baidu.tbadk.core.util.l.hA() && com.baidu.adp.gif.c.hz();
    }

    public static boolean ii(String str) {
        if (str == null) {
            return false;
        }
        if (ij(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.iQ().aO("portrait_cdn_open") != 0) && ik(str);
        }
        return true;
    }

    public static boolean ij(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean ik(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
