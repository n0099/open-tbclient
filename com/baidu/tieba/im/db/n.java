package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class n extends a {
    private static a aVB;
    public static String aVl = "tb_oficial_msg_";

    private n() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized n MT() {
        n nVar;
        synchronized (n.class) {
            if (aVB == null) {
                aVB = new n();
            }
            nVar = (n) aVB;
        }
        return nVar;
    }
}
