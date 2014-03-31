package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public final class n extends a {
    public static String b = "tb_private_msg_";
    private static a c;

    private n() {
        super("tb_private_msg_", com.baidu.tieba.im.message.a.f.class);
    }

    public static synchronized n d() {
        n nVar;
        synchronized (n.class) {
            if (c == null) {
                c = new n();
            }
            nVar = (n) c;
        }
        return nVar;
    }
}
