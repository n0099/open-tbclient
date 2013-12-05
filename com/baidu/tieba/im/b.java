package com.baidu.tieba.im;

import com.baidu.tieba.im.a.o;
import com.baidu.tieba.im.groupInfo.ResponseAddGroupUserMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
import com.baidu.tieba.im.groupInfo.ResponseJoinGroupMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.baidu.tieba.im.pushNotify.q;
/* loaded from: classes.dex */
public class b {
    public static void a() {
        try {
            a(1001, 1, new com.baidu.tieba.im.a.m());
            a(202003, 1, new com.baidu.tieba.im.d.h());
            a(1003, 1, new com.baidu.tieba.im.b.d(ResponsedMessage.class));
            a(202001, 1, new com.baidu.tieba.im.chat.i());
            a(202006, 1, new q());
            a(103002, 1, new com.baidu.tieba.im.a.b());
            a(103003, 1, new com.baidu.tieba.im.a.j());
            a(103101, 1, new com.baidu.tieba.im.a.a());
            a(103010, 1, new com.baidu.tieba.im.a.i());
            a(103102, 1, new com.baidu.tieba.im.a.n());
            a(103110, 1, new com.baidu.tieba.im.b.d(ResponseJoinGroupMessage.class));
            a(103111, 1, new com.baidu.tieba.im.b.d(ResponseAddGroupUserMessage.class));
            a(202004, 1, new com.baidu.tieba.im.b.d(ResponseDelSystemMessage.class));
            a(103005, 1, new com.baidu.tieba.im.a.f());
            a(103006, 1, new com.baidu.tieba.im.a.d());
            a(103112, 1, new com.baidu.tieba.im.b.d(ResponseRemoveMembersMessage.class));
            a(103004, 1, new com.baidu.tieba.im.a.c());
            a(103103, 1, new com.baidu.tieba.im.a.k());
            a(103007, 1, new com.baidu.tieba.im.a.l());
            a(103008, 1, new o());
            a(202101, 1, new com.baidu.tieba.im.b.d(ResponsedMessage.class));
            a(103009, 1, new com.baidu.tieba.im.a.g());
            a(103104, 1, new com.baidu.tieba.im.b.d(ResponseDismissGroupMessage.class));
            a(103011, 1, new com.baidu.tieba.im.a.h());
            a(103012, 1, new com.baidu.tieba.im.a.e());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(int i, int i2, com.baidu.tieba.im.b.n nVar) {
        com.baidu.tieba.im.b.c.b().a(i, i2, nVar);
    }
}
