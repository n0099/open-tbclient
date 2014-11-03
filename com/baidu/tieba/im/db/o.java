package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
public class o extends a {
    private static a aVB;
    public static String aVl = "tb_private_msg_";

    private o() {
        super("tb_private_msg_", PersonalChatMessage.class);
    }

    public static synchronized o MU() {
        o oVar;
        synchronized (o.class) {
            if (aVB == null) {
                aVB = new o();
            }
            oVar = (o) aVB;
        }
        return oVar;
    }
}
