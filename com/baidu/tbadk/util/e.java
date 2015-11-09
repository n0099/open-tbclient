package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class e {
    public static boolean Eo() {
        return Ep();
    }

    public static boolean Ep() {
        return com.baidu.tbadk.core.util.n.fi() && com.baidu.adp.gif.e.fh();
    }

    public static boolean fL(String str) {
        if (str == null) {
            return false;
        }
        if (fM(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.e.gv().af("portrait_cdn_open") != 0) && fN(str);
        }
        return true;
    }

    public static boolean fM(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean fN(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
