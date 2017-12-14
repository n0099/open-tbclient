package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String dJe = "tb_oficial_msg_";
    private static a dJt;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k azF() {
        k kVar;
        synchronized (k.class) {
            if (dJt == null) {
                dJt = new k();
            }
            kVar = (k) dJt;
        }
        return kVar;
    }
}
