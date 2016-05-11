package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String cff = "tb_oficial_msg_";
    private static a cfu;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k aeC() {
        k kVar;
        synchronized (k.class) {
            if (cfu == null) {
                cfu = new k();
            }
            kVar = (k) cfu;
        }
        return kVar;
    }
}
