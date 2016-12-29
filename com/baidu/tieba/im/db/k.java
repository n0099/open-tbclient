package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String cLa = "tb_oficial_msg_";
    private static a cLp;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k apo() {
        k kVar;
        synchronized (k.class) {
            if (cLp == null) {
                cLp = new k();
            }
            kVar = (k) cLp;
        }
        return kVar;
    }
}
