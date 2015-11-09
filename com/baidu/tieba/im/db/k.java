package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String bxi = "tb_oficial_msg_";
    private static a bxx;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k Uk() {
        k kVar;
        synchronized (k.class) {
            if (bxx == null) {
                bxx = new k();
            }
            kVar = (k) bxx;
        }
        return kVar;
    }
}
