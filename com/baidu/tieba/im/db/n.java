package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class n extends a {
    public static String aXZ = "tb_oficial_msg_";
    private static a aYp;

    private n() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized n Nj() {
        n nVar;
        synchronized (n.class) {
            if (aYp == null) {
                aYp = new n();
            }
            nVar = (n) aYp;
        }
        return nVar;
    }
}
