package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String dvg = "tb_oficial_msg_";
    private static a dvv;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k aws() {
        k kVar;
        synchronized (k.class) {
            if (dvv == null) {
                dvv = new k();
            }
            kVar = (k) dvv;
        }
        return kVar;
    }
}
