package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    private static a btM;
    public static String btx = "tb_oficial_msg_";

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k Tl() {
        k kVar;
        synchronized (k.class) {
            if (btM == null) {
                btM = new k();
            }
            kVar = (k) btM;
        }
        return kVar;
    }
}
