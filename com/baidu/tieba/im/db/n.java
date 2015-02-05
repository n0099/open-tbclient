package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class n extends a {
    public static String aXY = "tb_oficial_msg_";
    private static a aYo;

    private n() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized n Ne() {
        n nVar;
        synchronized (n.class) {
            if (aYo == null) {
                aYo = new n();
            }
            nVar = (n) aYo;
        }
        return nVar;
    }
}
