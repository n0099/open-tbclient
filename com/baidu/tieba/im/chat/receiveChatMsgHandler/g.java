package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class g implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ SystemMsgReceivedHandler a;
    private final /* synthetic */ com.baidu.tieba.im.data.c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SystemMsgReceivedHandler systemMsgReceivedHandler, com.baidu.tieba.im.data.c cVar) {
        this.a = systemMsgReceivedHandler;
        this.b = cVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(LinkedList<GroupNewsPojo> linkedList) {
        LinkedList<GroupNewsPojo> linkedList2 = linkedList;
        a.a(this.b);
        SystemMsgReceivedHandler.a(this.a, linkedList2);
        SystemMsgReceivedHandler.b(this.a, linkedList2);
    }
}
