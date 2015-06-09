package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class m extends a {
    public static String bfb = "tb_oficial_msg_";
    private static a bfq;

    private m() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized m RB() {
        m mVar;
        synchronized (m.class) {
            if (bfq == null) {
                bfq = new m();
            }
            mVar = (m) bfq;
        }
        return mVar;
    }
}
