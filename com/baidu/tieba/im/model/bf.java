package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bf implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ bc a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(bc bcVar, com.baidu.tieba.im.a aVar) {
        this.a = bcVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r3) {
        LinkedList linkedList;
        LinkedList linkedList2;
        LinkedList<ImMessageCenterShowItemData> h = com.baidu.tieba.im.pushNotify.a.d().h();
        if (h != null) {
            linkedList = this.a.a;
            linkedList.clear();
            linkedList2 = this.a.a;
            linkedList2.addAll(h);
            bc.b(this.a);
            if (this.b != null) {
                this.b.a(null);
            }
        }
    }
}
