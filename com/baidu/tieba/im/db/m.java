package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class m extends a {
    private static a bcL;
    public static String bcw = "tb_oficial_msg_";

    private m() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized m Ql() {
        m mVar;
        synchronized (m.class) {
            if (bcL == null) {
                bcL = new m();
            }
            mVar = (m) bcL;
        }
        return mVar;
    }
}
