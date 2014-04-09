package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class w implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ u a;
    private final /* synthetic */ GroupMsgData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(u uVar, GroupMsgData groupMsgData) {
        this.a = uVar;
        this.b = groupMsgData;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(LinkedList<GroupNewsPojo> linkedList) {
        LinkedList<GroupNewsPojo> linkedList2 = linkedList;
        b.a(this.b, false);
        u.a(this.a, linkedList2);
        u.b(this.a, linkedList2);
    }
}
