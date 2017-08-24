package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean Hd() {
        return He();
    }

    public static boolean He() {
        return com.baidu.tbadk.core.util.k.dR() && com.baidu.adp.gif.c.dQ();
    }

    public static boolean gK(String str) {
        if (str == null) {
            return false;
        }
        if (gL(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.fh().am("portrait_cdn_open") != 0) && gM(str);
        }
        return true;
    }

    public static boolean gL(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gM(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
