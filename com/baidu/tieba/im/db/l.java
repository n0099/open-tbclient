package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class l extends a {
    public static String cSV = "tb_oficial_msg_";
    private static a cTk;

    private l() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized l apI() {
        l lVar;
        synchronized (l.class) {
            if (cTk == null) {
                cTk = new l();
            }
            lVar = (l) cTk;
        }
        return lVar;
    }
}
