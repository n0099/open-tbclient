package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.InterfaceC0059a {
    final /* synthetic */ b bzO;
    private final /* synthetic */ List bzP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(b bVar, List list) {
        this.bzO = bVar;
        this.bzP = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.bzP.add(it.next());
        }
    }
}
