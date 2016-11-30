package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String dgf = "tb_oficial_msg_";
    private static a dgu;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k auP() {
        k kVar;
        synchronized (k.class) {
            if (dgu == null) {
                dgu = new k();
            }
            kVar = (k) dgu;
        }
        return kVar;
    }
}
