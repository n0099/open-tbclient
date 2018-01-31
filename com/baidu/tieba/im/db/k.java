package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String exh = "tb_oficial_msg_";
    private static a exx;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k aGQ() {
        k kVar;
        synchronized (k.class) {
            if (exx == null) {
                exx = new k();
            }
            kVar = (k) exx;
        }
        return kVar;
    }
}
