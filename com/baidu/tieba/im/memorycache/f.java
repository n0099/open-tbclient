package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements a.InterfaceC0067a {
    final /* synthetic */ b dnO;
    private final /* synthetic */ List dnP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, List list) {
        this.dnO = bVar;
        this.dnP = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0067a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 1 && next.getIs_hidden() == 0) {
                this.dnP.add(next);
            }
        }
    }
}
