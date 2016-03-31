package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0065a {
    final /* synthetic */ b clR;
    private final /* synthetic */ List clS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, List list) {
        this.clR = bVar;
        this.clS = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0065a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.clS.add(it.next());
        }
    }
}
