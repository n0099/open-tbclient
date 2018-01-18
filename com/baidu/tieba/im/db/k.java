package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class k extends a {
    public static String ewM = "tb_oficial_msg_";
    private static a exb;

    private k() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized k aGL() {
        k kVar;
        synchronized (k.class) {
            if (exb == null) {
                exb = new k();
            }
            kVar = (k) exb;
        }
        return kVar;
    }
}
