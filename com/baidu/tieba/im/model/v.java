package com.baidu.tieba.im.model;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ r a;
    private final /* synthetic */ String b;
    private final /* synthetic */ com.baidu.tieba.im.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(r rVar, String str, com.baidu.tieba.im.a aVar) {
        this.a = rVar;
        this.b = str;
        this.c = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r6) {
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
        com.baidu.tieba.im.pushNotify.a.f().b(this.b);
        com.baidu.tieba.im.pushNotify.a.f().b(false, this.c);
    }
}
