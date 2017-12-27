package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    private static a evD;
    public static String evo = "tb_oficial_msg_";

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k aGG() {
        k kVar;
        synchronized (k.class) {
            if (evD == null) {
                evD = new k();
            }
            kVar = (k) evD;
        }
        return kVar;
    }
}
