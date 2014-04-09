package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
/* loaded from: classes.dex */
public final class x {
    private static x a;

    private x() {
    }

    public static synchronized x a() {
        x xVar;
        synchronized (x.class) {
            if (a == null) {
                a = new x();
            }
            xVar = a;
        }
        return xVar;
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
