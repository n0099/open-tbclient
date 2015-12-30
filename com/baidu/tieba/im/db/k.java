package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String bPU = "tb_oficial_msg_";
    private static a bQj;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k Yw() {
        k kVar;
        synchronized (k.class) {
            if (bQj == null) {
                bQj = new k();
            }
            kVar = (k) bQj;
        }
        return kVar;
    }
}
