package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
public class o extends a {
    public static String b = "tb_private_msg_";
    private static a c;

    private o() {
        super("tb_private_msg_", PersonalChatMessage.class);
    }

    public static synchronized o c() {
        o oVar;
        synchronized (o.class) {
            if (c == null) {
                c = new o();
            }
            oVar = (o) c;
        }
        return oVar;
    }
}
