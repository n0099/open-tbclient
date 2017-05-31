package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class l extends a {
    public static String cUM = "tb_oficial_msg_";
    private static a cVb;

    private l() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized l aoC() {
        l lVar;
        synchronized (l.class) {
            if (cVb == null) {
                cVb = new l();
            }
            lVar = (l) cVb;
        }
        return lVar;
    }
}
