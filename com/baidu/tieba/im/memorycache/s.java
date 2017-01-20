package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements a.InterfaceC0066a {
    final /* synthetic */ b cZS;
    private final /* synthetic */ List cZT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(b bVar, List list) {
        this.cZS = bVar;
        this.cZT = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0066a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.cZT.add(it.next());
        }
    }
}
