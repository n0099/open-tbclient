package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class g {
    public static boolean DV() {
        return DW();
    }

    public static boolean DW() {
        return com.baidu.tbadk.core.util.o.fo() && com.baidu.adp.gif.f.fn();
    }

    public static boolean fe(String str) {
        if (str == null) {
            return false;
        }
        if (ff(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.f.gD().ai("portrait_cdn_open") != 0) && fg(str);
        }
        return true;
    }

    public static boolean ff(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean fg(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
