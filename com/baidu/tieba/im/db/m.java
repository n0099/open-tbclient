package com.baidu.tieba.im.db;
/* loaded from: classes.dex */
public final class m extends a {
    public static String b = "tb_oficial_msg_";
    private static a c;

    private m() {
        super("tb_oficial_msg_", com.baidu.tieba.im.message.a.e.class);
    }

    public static synchronized m d() {
        m mVar;
        synchronized (m.class) {
            if (c == null) {
                c = new m();
            }
            mVar = (m) c;
        }
        return mVar;
    }
}
