package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class e {
    public static boolean Fe() {
        return Ff();
    }

    public static boolean Ff() {
        return com.baidu.tbadk.core.util.n.fi() && com.baidu.adp.gif.e.fh();
    }

    public static boolean gd(String str) {
        if (str == null) {
            return false;
        }
        if (ge(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.c.e.gw().aj("portrait_cdn_open") != 0) && gf(str);
        }
        return true;
    }

    public static boolean ge(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gf(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
