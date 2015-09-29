package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String bwA = "tb_oficial_msg_";
    private static a bwP;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k TT() {
        k kVar;
        synchronized (k.class) {
            if (bwP == null) {
                bwP = new k();
            }
            kVar = (k) bwP;
        }
        return kVar;
    }
}
