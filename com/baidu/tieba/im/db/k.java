package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String dmG = "tb_oficial_msg_";
    private static a dmV;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k aud() {
        k kVar;
        synchronized (k.class) {
            if (dmV == null) {
                dmV = new k();
            }
            kVar = (k) dmV;
        }
        return kVar;
    }
}
