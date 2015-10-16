package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.InterfaceC0059a {
    final /* synthetic */ b bDI;
    private final /* synthetic */ List bDJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(b bVar, List list) {
        this.bDI = bVar;
        this.bDJ = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.bDJ.add(it.next());
        }
    }
}
