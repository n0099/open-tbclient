package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends SingleRunnable<LinkedList<GroupNewsPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupMsgData f1781a;
    final /* synthetic */ int b;
    final /* synthetic */ n c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar, GroupMsgData groupMsgData, int i) {
        this.c = nVar;
        this.f1781a = groupMsgData;
        this.b = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public LinkedList<GroupNewsPojo> b() {
        LinkedList<GroupNewsPojo> b;
        b = this.c.b(this.f1781a, this.b);
        return b;
    }
}
