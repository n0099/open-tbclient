package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.InterfaceC0059a {
    final /* synthetic */ b bDx;
    private final /* synthetic */ List bDy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(b bVar, List list) {
        this.bDx = bVar;
        this.bDy = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.bDy.add(it.next());
        }
    }
}
