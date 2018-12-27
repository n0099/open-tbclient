package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean PR() {
        return PS();
    }

    public static boolean PS() {
        return com.baidu.tbadk.core.util.l.hA() && com.baidu.adp.gif.c.hz();
    }

    public static boolean iB(String str) {
        if (str == null) {
            return false;
        }
        if (iC(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.iQ().aO("portrait_cdn_open") != 0) && iD(str);
        }
        return true;
    }

    public static boolean iC(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean iD(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
