package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    private static a daI;
    public static String dar = "tb_oficial_msg_";

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k asS() {
        k kVar;
        synchronized (k.class) {
            if (daI == null) {
                daI = new k();
            }
            kVar = (k) daI;
        }
        return kVar;
    }
}
