package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class n extends a {
    public static String aUX = "tb_oficial_msg_";
    private static a aVn;

    private n() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized n MP() {
        n nVar;
        synchronized (n.class) {
            if (aVn == null) {
                aVn = new n();
            }
            nVar = (n) aVn;
        }
        return nVar;
    }
}
