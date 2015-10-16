package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String bwL = "tb_oficial_msg_";
    private static a bxa;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k TT() {
        k kVar;
        synchronized (k.class) {
            if (bxa == null) {
                bxa = new k();
            }
            kVar = (k) bxa;
        }
        return kVar;
    }
}
