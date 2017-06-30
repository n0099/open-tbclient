package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class l extends a {
    public static String dcJ = "tb_oficial_msg_";
    private static a dcY;

    private l() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized l asn() {
        l lVar;
        synchronized (l.class) {
            if (dcY == null) {
                dcY = new l();
            }
            lVar = (l) dcY;
        }
        return lVar;
    }
}
