package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a.InterfaceC0064a {
    final /* synthetic */ b cUZ;
    private final /* synthetic */ List cVa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, List list) {
        this.cUZ = bVar;
        this.cVa = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0) {
                this.cVa.add(next);
            }
        }
    }
}
