package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class g {
    public static boolean Df() {
        return Dg();
    }

    public static boolean Dg() {
        return com.baidu.tbadk.core.util.o.fj() && com.baidu.adp.gif.f.fi();
    }

    public static boolean eG(String str) {
        if (str == null) {
            return false;
        }
        if (eH(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.f.gz().ag("portrait_cdn_open") != 0) && eI(str);
        }
        return true;
    }

    public static boolean eH(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean eI(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
