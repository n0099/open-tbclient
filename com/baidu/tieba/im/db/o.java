package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class o extends a {
    public static String b = "tb_oficial_msg_";
    private static a c;

    private o() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized o d() {
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
