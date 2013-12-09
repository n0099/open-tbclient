package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.SingleRunnable;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends SingleRunnable<LinkedList<GroupNewsPojo>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ GroupMsgData f1868a;
    final /* synthetic */ int b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, GroupMsgData groupMsgData, int i) {
        this.c = lVar;
        this.f1868a = groupMsgData;
        this.b = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.SingleRunnable
    /* renamed from: a */
    public LinkedList<GroupNewsPojo> b() {
        LinkedList<GroupNewsPojo> b;
        b = this.c.b(this.f1868a, this.b);
        return b;
    }
}
