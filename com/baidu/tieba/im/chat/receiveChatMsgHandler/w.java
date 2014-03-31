package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
/* loaded from: classes.dex */
public final class w {
    private static w a;

    private w() {
    }

    public static synchronized w a() {
        w wVar;
        synchronized (w.class) {
            if (a == null) {
                a = new w();
            }
            wVar = a;
        }
        return wVar;
    }

    public static void a(String str, long j) {
        if (!TextUtils.isEmpty(str) && j > 0) {
            com.baidu.tbadk.coreExtra.messageCenter.d.a().a(com.baidu.adp.lib.f.b.a(str, -1), j);
            com.baidu.tbadk.s.a();
            com.baidu.tbadk.s.b("tb_group_msg_" + str, j);
        }
    }

    public static long a(int i) {
        com.baidu.tbadk.s.a();
        return com.baidu.tbadk.s.a("tb_group_msg_" + i, -1L);
    }
}
