package com.baidu.tieba.im.db;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
public class m extends a {
    public static String bfa = "tb_oficial_msg_";
    private static a bfp;

    private m() {
        super("tb_oficial_msg_", OfficialChatMessage.class);
    }

    public static synchronized m RA() {
        m mVar;
        synchronized (m.class) {
            if (bfp == null) {
                bfp = new m();
            }
            mVar = (m) bfp;
        }
        return mVar;
    }
}
