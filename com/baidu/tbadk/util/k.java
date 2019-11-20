package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class k {
    public static boolean axw() {
        return axx();
    }

    public static boolean axx() {
        return com.baidu.tbadk.core.util.m.checkSD() && com.baidu.adp.gif.c.eO();
    }

    public static boolean canUseIp(String str) {
        if (str == null) {
            return false;
        }
        if (isCdn(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.ft().af("portrait_cdn_open") != 0) && isPortrait(str);
        }
        return true;
    }

    public static boolean isCdn(String str) {
        if (str == null) {
            return false;
        }
        int indexOf = str.indexOf("hiphotos");
        if (indexOf <= 0 || indexOf >= 20) {
            int indexOf2 = str.indexOf("tiebapic");
            return indexOf2 > 0 && indexOf2 < 20;
        }
        return true;
    }

    public static boolean ql(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tiebapic")) > 0 && indexOf < 20;
    }

    public static boolean isPortrait(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
