package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class t implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ p a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.tieba.im.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, String str, com.baidu.tieba.im.a aVar) {
        this.a = pVar;
        this.b = str;
        this.c = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r6) {
        List list;
        ImMessageCenterShowItemData imMessageCenterShowItemData;
        List list2;
        list = this.a.b;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                imMessageCenterShowItemData = null;
                break;
            }
            imMessageCenterShowItemData = (ImMessageCenterShowItemData) it.next();
            if (this.b.equals(imMessageCenterShowItemData.getFriendId())) {
                break;
            }
        }
        if (imMessageCenterShowItemData != null) {
            list2 = this.a.b;
            list2.remove(imMessageCenterShowItemData);
        }
        com.baidu.tieba.im.pushNotify.a.d().a(this.b);
        com.baidu.tieba.im.pushNotify.a.d().b(false, this.c);
    }
}
