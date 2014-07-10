package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ p a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(p pVar, com.baidu.tieba.im.a aVar) {
        this.a = pVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        List list;
        List list2;
        LinkedList<ImMessageCenterShowItemData> m = com.baidu.tieba.im.pushNotify.a.i().m();
        if (m != null) {
            list = this.a.b;
            list.clear();
            list2 = this.a.b;
            list2.addAll(m);
            this.a.e();
            this.b.a(r3);
        }
    }
}
