package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    private static a ceO;
    public static String cez = "tb_oficial_msg_";

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k aeD() {
        k kVar;
        synchronized (k.class) {
            if (ceO == null) {
                ceO = new k();
            }
            kVar = (k) ceO;
        }
        return kVar;
    }
}
