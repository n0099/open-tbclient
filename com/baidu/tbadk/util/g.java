package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class g {
    public static boolean Dl() {
        return Dm();
    }

    public static boolean Dm() {
        return com.baidu.tbadk.core.util.o.fj() && com.baidu.adp.gif.f.fi();
    }

    public static boolean eJ(String str) {
        if (str == null) {
            return false;
        }
        if (eK(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.f.gz().ag("portrait_cdn_open") != 0) && eL(str);
        }
        return true;
    }

    public static boolean eK(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean eL(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
