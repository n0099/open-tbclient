package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
class g implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ SystemMsgReceivedHandler a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SystemMsgReceivedHandler systemMsgReceivedHandler) {
        this.a = systemMsgReceivedHandler;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        this.a.a(linkedList);
        this.a.b(linkedList);
    }
}
