package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class h {
    public static boolean Gp() {
        return Gq();
    }

    public static boolean Gq() {
        return com.baidu.tbadk.core.util.l.dH() && com.baidu.adp.gif.e.dG();
    }

    public static boolean gc(String str) {
        if (str == null) {
            return false;
        }
        if (gd(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.e.eZ().Y("portrait_cdn_open") != 0) && ge(str);
        }
        return true;
    }

    public static boolean gd(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean ge(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
