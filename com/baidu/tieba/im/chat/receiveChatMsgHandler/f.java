package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
class f extends com.baidu.tieba.im.c<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ SystemMsgReceivedHandler a;
    private final /* synthetic */ com.baidu.tieba.im.data.c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SystemMsgReceivedHandler systemMsgReceivedHandler, com.baidu.tieba.im.data.c cVar) {
        this.a = systemMsgReceivedHandler;
        this.c = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public LinkedList<GroupNewsPojo> b() {
        LinkedList<GroupNewsPojo> b;
        b = this.a.b(this.c);
        return b;
    }
}
