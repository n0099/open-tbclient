package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ r a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(r rVar, com.baidu.tieba.im.a aVar) {
        this.a = rVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        List list;
        List list2;
        LinkedList<ImMessageCenterShowItemData> j = com.baidu.tieba.im.pushNotify.a.f().j();
        if (j != null) {
            list = this.a.b;
            list.clear();
            list2 = this.a.b;
            list2.addAll(j);
            this.a.d();
            this.b.a(r3);
        }
    }
}
