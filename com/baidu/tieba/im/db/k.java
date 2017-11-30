package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String dIb = "tb_oficial_msg_";
    private static a dIq;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k azw() {
        k kVar;
        synchronized (k.class) {
            if (dIq == null) {
                dIq = new k();
            }
            kVar = (k) dIq;
        }
        return kVar;
    }
}
