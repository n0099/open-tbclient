package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public final class o extends a {
    public static String b = "tb_private_msg_";
    private static a c;

    private o() {
        super("tb_private_msg_", com.baidu.tieba.im.message.a.f.class);
    }

    public static synchronized o d() {
        o oVar;
        synchronized (o.class) {
            if (c == null) {
                c = new o();
            }
            oVar = (o) c;
        }
        return oVar;
    }
}
