package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String bTW = "tb_oficial_msg_";
    private static a bUl;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k abh() {
        k kVar;
        synchronized (k.class) {
            if (bUl == null) {
                bUl = new k();
            }
            kVar = (k) bUl;
        }
        return kVar;
    }
}
