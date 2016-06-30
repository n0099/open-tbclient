package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.InterfaceC0064a {
    final /* synthetic */ b cSe;
    private final /* synthetic */ List cSf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(b bVar, List list) {
        this.cSe = bVar;
        this.cSf = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.cSf.add(it.next());
        }
    }
}
