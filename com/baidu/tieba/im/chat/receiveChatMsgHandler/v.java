package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class v implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ t a;
    private final /* synthetic */ GroupMsgData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, GroupMsgData groupMsgData) {
        this.a = tVar;
        this.b = groupMsgData;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(LinkedList<GroupNewsPojo> linkedList) {
        LinkedList<GroupNewsPojo> linkedList2 = linkedList;
        b.a(this.b, false);
        t.a(this.a, linkedList2);
        t.b(this.a, linkedList2);
    }
}
