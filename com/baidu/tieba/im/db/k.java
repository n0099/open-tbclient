package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    private static a cNE;
    public static String cNp = "tb_oficial_msg_";

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k anE() {
        k kVar;
        synchronized (k.class) {
            if (cNE == null) {
                cNE = new k();
            }
            kVar = (k) cNE;
        }
        return kVar;
    }
}
