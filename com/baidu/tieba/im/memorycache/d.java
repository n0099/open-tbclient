package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0059a {
    final /* synthetic */ b bAv;
    private final /* synthetic */ List bAw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, List list) {
        this.bAv = bVar;
        this.bAw = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.bAw.add(it.next());
        }
    }
}
