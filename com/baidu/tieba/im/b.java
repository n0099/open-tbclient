package com.baidu.tieba.im;

import com.baidu.tieba.im.groupInfo.ResponseAddGroupUserMessage;
import com.baidu.tieba.im.groupInfo.ResponseDelSystemMessage;
import com.baidu.tieba.im.groupInfo.ResponseJoinGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.baidu.tieba.im.pushNotify.s;
/* loaded from: classes.dex */
public class b {
    public static void a() {
        try {
            a(1001, 1, new com.baidu.tieba.im.a.i());
            a(202003, 1, new com.baidu.tieba.im.c.h());
            a(1003, 1, new com.baidu.tieba.im.codec.d(ResponsedMessage.class));
            a(202001, 1, new com.baidu.tieba.im.chat.k());
            a(202006, 1, new s());
            a(103002, 1, new com.baidu.tieba.im.a.b());
            a(103003, 1, new com.baidu.tieba.im.a.f());
            a(103101, 1, new com.baidu.tieba.im.a.a());
            a(103102, 1, new com.baidu.tieba.im.a.j());
            a(103110, 1, new com.baidu.tieba.im.codec.d(ResponseJoinGroupMessage.class));
            a(103111, 1, new com.baidu.tieba.im.codec.d(ResponseAddGroupUserMessage.class));
            a(202004, 1, new com.baidu.tieba.im.codec.d(ResponseDelSystemMessage.class));
            a(103005, 1, new com.baidu.tieba.im.a.e());
            a(103006, 1, new com.baidu.tieba.im.a.d());
            a(103112, 1, new com.baidu.tieba.im.codec.d(ResponseRemoveMembersMessage.class));
            a(103004, 1, new com.baidu.tieba.im.a.c());
            a(103103, 1, new com.baidu.tieba.im.a.g());
            a(103007, 1, new com.baidu.tieba.im.a.h());
            a(103008, 1, new com.baidu.tieba.im.a.k());
            a(202101, 1, new com.baidu.tieba.im.codec.d(ResponsedMessage.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(int i, int i2, com.baidu.tieba.im.codec.n nVar) {
        com.baidu.tieba.im.codec.c.b().a(i, i2, nVar);
    }
}
