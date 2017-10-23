package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String dse = "tb_oficial_msg_";
    private static a dst;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k avj() {
        k kVar;
        synchronized (k.class) {
            if (dst == null) {
                dst = new k();
            }
            kVar = (k) dst;
        }
        return kVar;
    }
}
