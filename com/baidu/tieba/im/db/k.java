package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String doE = "tb_oficial_msg_";
    private static a doT;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k auF() {
        k kVar;
        synchronized (k.class) {
            if (doT == null) {
                doT = new k();
            }
            kVar = (k) doT;
        }
        return kVar;
    }
}
