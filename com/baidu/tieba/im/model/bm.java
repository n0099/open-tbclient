package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bm implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ bj a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(bj bjVar, com.baidu.tieba.im.a aVar) {
        this.a = bjVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList<ImMessageCenterShowItemData> m = com.baidu.tieba.im.pushNotify.a.f().m();
        if (m != null) {
            linkedList = this.a.a;
            linkedList.clear();
            linkedList2 = this.a.a;
            linkedList2.addAll(m);
            this.a.b();
            if (this.b != null) {
                this.b.a(null);
            }
        }
    }
}
