package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean MC() {
        return MD();
    }

    public static boolean MD() {
        return com.baidu.tbadk.core.util.l.hk() && com.baidu.adp.gif.c.hj();
    }

    public static boolean hS(String str) {
        if (str == null) {
            return false;
        }
        if (hT(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.iB().aO("portrait_cdn_open") != 0) && hU(str);
        }
        return true;
    }

    public static boolean hT(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean hU(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
