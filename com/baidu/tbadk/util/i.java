package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class i {
    public static boolean Hf() {
        return Hg();
    }

    public static boolean Hg() {
        return com.baidu.tbadk.core.util.k.dG() && com.baidu.adp.gif.c.dF();
    }

    public static boolean gM(String str) {
        if (str == null) {
            return false;
        }
        if (gN(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.d.eV().af("portrait_cdn_open") != 0) && gO(str);
        }
        return true;
    }

    public static boolean gN(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean gO(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
