package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class m extends a {
    public static String bcg = "tb_oficial_msg_";
    private static a bcv;

    private m() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized m PY() {
        m mVar;
        synchronized (m.class) {
            if (bcv == null) {
                bcv = new m();
            }
            mVar = (m) bcv;
        }
        return mVar;
    }
}
