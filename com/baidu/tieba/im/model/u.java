package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.LinkedList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ p a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(p pVar, com.baidu.tieba.im.a aVar) {
        this.a = pVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r3) {
        List list;
        List list2;
        LinkedList<ImMessageCenterShowItemData> e = com.baidu.tieba.im.pushNotify.a.d().e();
        if (e != null) {
            list = this.a.b;
            list.clear();
            list2 = this.a.b;
            list2.addAll(e);
            this.a.c();
            if (this.b != null) {
                this.b.a(null);
            }
        }
    }
}
