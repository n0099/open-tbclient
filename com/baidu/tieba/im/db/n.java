package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class n extends a {
    public static String aWD = "tb_oficial_msg_";
    private static a aWT;

    private n() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized n MN() {
        n nVar;
        synchronized (n.class) {
            if (aWT == null) {
                aWT = new n();
            }
            nVar = (n) aWT;
        }
        return nVar;
    }
}
