package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class u extends com.baidu.tieba.im.m<LinkedList<GroupNewsPojo>> {
    final /* synthetic */ t b;
    private final /* synthetic */ GroupMsgData c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar, GroupMsgData groupMsgData) {
        this.b = tVar;
        this.c = groupMsgData;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* bridge */ /* synthetic */ LinkedList<GroupNewsPojo> a() {
        LinkedList<GroupNewsPojo> a;
        t tVar = this.b;
        a = t.a(this.c);
        return a;
    }
}
