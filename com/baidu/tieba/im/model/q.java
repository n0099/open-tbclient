package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class q extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ p b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, LinkedList linkedList) {
        this.b = pVar;
        this.c = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            String c = com.baidu.tieba.im.db.g.c(((ImMessageCenterShowItemData) it.next()).getFriendId());
            com.baidu.tieba.im.db.g.a();
            com.baidu.tieba.im.db.g.a(c, true);
        }
        return null;
    }
}
