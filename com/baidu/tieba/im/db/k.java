package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String dwb = "tb_oficial_msg_";
    private static a dwq;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k awD() {
        k kVar;
        synchronized (k.class) {
            if (dwq == null) {
                dwq = new k();
            }
            kVar = (k) dwq;
        }
        return kVar;
    }
}
