package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String cSi = "tb_oficial_msg_";
    private static a cSx;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k aqv() {
        k kVar;
        synchronized (k.class) {
            if (cSx == null) {
                cSx = new k();
            }
            kVar = (k) cSx;
        }
        return kVar;
    }
}
