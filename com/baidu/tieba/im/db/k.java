package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String bsR = "tb_oficial_msg_";
    private static a btg;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k Tj() {
        k kVar;
        synchronized (k.class) {
            if (btg == null) {
                btg = new k();
            }
            kVar = (k) btg;
        }
        return kVar;
    }
}
