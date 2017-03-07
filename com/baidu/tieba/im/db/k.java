package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    private static a cUN;
    public static String cUy = "tb_oficial_msg_";

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k apP() {
        k kVar;
        synchronized (k.class) {
            if (cUN == null) {
                cUN = new k();
            }
            kVar = (k) cUN;
        }
        return kVar;
    }
}
