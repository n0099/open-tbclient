package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class f extends com.baidu.tieba.im.b<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ SystemMsgReceivedHandler a;
    private final /* synthetic */ com.baidu.tieba.im.data.c c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(SystemMsgReceivedHandler systemMsgReceivedHandler, com.baidu.tieba.im.data.c cVar) {
        this.a = systemMsgReceivedHandler;
        this.c = cVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* bridge */ /* synthetic */ LinkedList<GroupNewsPojo> a() {
        LinkedList<GroupNewsPojo> b;
        SystemMsgReceivedHandler systemMsgReceivedHandler = this.a;
        b = SystemMsgReceivedHandler.b(this.c);
        return b;
    }
}
