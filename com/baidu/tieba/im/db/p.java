package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
public class p extends a {
    public static String b = "tb_private_msg_";
    private static a c;

    private p() {
        super("tb_private_msg_", PersonalChatMessage.class);
    }

    public static synchronized p d() {
        p pVar;
        synchronized (p.class) {
            if (c == null) {
                c = new p();
            }
            pVar = (p) c;
        }
        return pVar;
    }
}
