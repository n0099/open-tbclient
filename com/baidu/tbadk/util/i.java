package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean HC() {
        return HD();
    }

    public static boolean HD() {
        return com.baidu.tbadk.core.util.k.m15do() && com.baidu.adp.gif.c.dn();
    }

    public static boolean gZ(String str) {
        if (str == null) {
            return false;
        }
        if (ha(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.eE().ak("portrait_cdn_open") != 0) && hb(str);
        }
        return true;
    }

    public static boolean ha(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean hb(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
