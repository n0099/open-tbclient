package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class l extends a {
    private static a cVB;
    public static String cVm = "tb_oficial_msg_";

    private l() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized l aqJ() {
        l lVar;
        synchronized (l.class) {
            if (cVB == null) {
                cVB = new l();
            }
            lVar = (l) cVB;
        }
        return lVar;
    }
}
