package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.InterfaceC0064a {
    final /* synthetic */ b dda;
    private final /* synthetic */ List ddb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(b bVar, List list) {
        this.dda = bVar;
        this.ddb = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.ddb.add(it.next());
        }
    }
}
