package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class l extends a {
    private static a cPD;
    public static String cPo = "tb_oficial_msg_";

    private l() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized l anC() {
        l lVar;
        synchronized (l.class) {
            if (cPD == null) {
                cPD = new l();
            }
            lVar = (l) cPD;
        }
        return lVar;
    }
}
