package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean Lm() {
        return Ln();
    }

    public static boolean Ln() {
        return com.baidu.tbadk.core.util.l.ge() && com.baidu.adp.gif.c.gd();
    }

    public static boolean hy(String str) {
        if (str == null) {
            return false;
        }
        if (hz(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.hv().aw("portrait_cdn_open") != 0) && hA(str);
        }
        return true;
    }

    public static boolean hz(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean hA(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
