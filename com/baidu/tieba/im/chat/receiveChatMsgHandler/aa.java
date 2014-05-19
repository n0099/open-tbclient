package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements com.baidu.tieba.im.a<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ y a;
    private final /* synthetic */ GroupMsgData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar, GroupMsgData groupMsgData) {
        this.a = yVar;
        this.b = groupMsgData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(LinkedList<GroupNewsPojo> linkedList) {
        b.a(this.b, false);
        this.a.a(linkedList);
        this.a.b(linkedList);
    }
}
