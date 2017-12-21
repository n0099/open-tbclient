package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String dJi = "tb_oficial_msg_";
    private static a dJx;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k azF() {
        k kVar;
        synchronized (k.class) {
            if (dJx == null) {
                dJx = new k();
            }
            kVar = (k) dJx;
        }
        return kVar;
    }
}
