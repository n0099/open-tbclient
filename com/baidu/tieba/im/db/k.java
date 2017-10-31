package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    private static a dAi;
    public static String dzT = "tb_oficial_msg_";

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k axE() {
        k kVar;
        synchronized (k.class) {
            if (dAi == null) {
                dAi = new k();
            }
            kVar = (k) dAi;
        }
        return kVar;
    }
}
