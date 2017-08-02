package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    private static a dlD;
    public static String dlo = "tb_oficial_msg_";

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k atS() {
        k kVar;
        synchronized (k.class) {
            if (dlD == null) {
                dlD = new k();
            }
            kVar = (k) dlD;
        }
        return kVar;
    }
}
