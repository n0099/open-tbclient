package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
public class o extends a {
    public static String aUX = "tb_private_msg_";
    private static a aVn;

    private o() {
        super("tb_private_msg_", PersonalChatMessage.class);
    }

    public static synchronized o MQ() {
        o oVar;
        synchronized (o.class) {
            if (aVn == null) {
                aVn = new o();
            }
            oVar = (o) aVn;
        }
        return oVar;
    }
}
