package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String cYU = "tb_oficial_msg_";
    private static a cZj;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k ast() {
        k kVar;
        synchronized (k.class) {
            if (cZj == null) {
                cZj = new k();
            }
            kVar = (k) cZj;
        }
        return kVar;
    }
}
