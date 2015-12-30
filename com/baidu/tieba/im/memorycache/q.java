package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.InterfaceC0062a {
    final /* synthetic */ b bWT;
    private final /* synthetic */ List bWU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(b bVar, List list) {
        this.bWT = bVar;
        this.bWU = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0062a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.bWU.add(it.next());
        }
    }
}
