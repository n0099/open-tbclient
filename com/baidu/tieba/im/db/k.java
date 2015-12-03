package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    private static a bMD;
    public static String bMo = "tb_oficial_msg_";

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k Xq() {
        k kVar;
        synchronized (k.class) {
            if (bMD == null) {
                bMD = new k();
            }
            kVar = (k) bMD;
        }
        return kVar;
    }
}
