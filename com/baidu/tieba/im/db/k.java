package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    private static a dsG;
    public static String dsr = "tb_oficial_msg_";

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k avo() {
        k kVar;
        synchronized (k.class) {
            if (dsG == null) {
                dsG = new k();
            }
            kVar = (k) dsG;
        }
        return kVar;
    }
}
