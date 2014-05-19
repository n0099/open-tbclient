package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends com.baidu.tieba.im.b<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ y b;
    private final /* synthetic */ GroupMsgData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar, GroupMsgData groupMsgData) {
        this.b = yVar;
        this.c = groupMsgData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public LinkedList<GroupNewsPojo> a() {
        LinkedList<GroupNewsPojo> a;
        a = this.b.a(this.c);
        return a;
    }
}
