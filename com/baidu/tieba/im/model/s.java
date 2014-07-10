package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
class s extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ p b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, LinkedList linkedList) {
        this.b = pVar;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            com.baidu.tieba.im.db.h.a().a(com.baidu.tieba.im.db.h.c(((ImMessageCenterShowItemData) it.next()).getFriendId()), true);
        }
        return null;
    }
}
