package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    private static a cKO;
    public static String cKz = "tb_oficial_msg_";

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k amT() {
        k kVar;
        synchronized (k.class) {
            if (cKO == null) {
                cKO = new k();
            }
            kVar = (k) cKO;
        }
        return kVar;
    }
}
