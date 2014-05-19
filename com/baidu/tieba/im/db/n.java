package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class n extends a {
    public static String b = "tb_oficial_msg_";
    private static a c;

    private n() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized n d() {
        n nVar;
        synchronized (n.class) {
            if (c == null) {
                c = new n();
            }
            nVar = (n) c;
        }
        return nVar;
    }
}
