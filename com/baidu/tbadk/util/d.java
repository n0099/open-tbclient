package com.baidu.tbadk.util;
/* loaded from: classes.dex */
public class d {
    public static boolean EL() {
        return EM();
    }

    public static boolean EM() {
        return com.baidu.tbadk.core.util.n.fi() && com.baidu.adp.gif.e.fh();
    }

    public static boolean fE(String str) {
        if (str == null) {
            return false;
        }
        if (fF(str)) {
            return true;
        }
        int indexOf = str.indexOf("imgsrc");
        if (indexOf <= 0 || indexOf >= 20) {
            return (com.baidu.adp.lib.b.e.gv().ah("portrait_cdn_open") != 0) && fG(str);
        }
        return true;
    }

    public static boolean fF(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("hiphotos")) > 0 && indexOf < 20;
    }

    public static boolean fG(String str) {
        int indexOf;
        return str != null && (indexOf = str.indexOf("tb.himg")) > 0 && indexOf < 20;
    }
}
