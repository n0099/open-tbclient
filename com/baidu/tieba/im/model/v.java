package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
final class v implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(p pVar) {
        this.a = pVar;
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
            this.a.d();
        }
    }
}
