package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    private static a dAC;
    public static String dAn = "tb_oficial_msg_";

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k axW() {
        k kVar;
        synchronized (k.class) {
            if (dAC == null) {
                dAC = new k();
            }
            kVar = (k) dAC;
        }
        return kVar;
    }
}
