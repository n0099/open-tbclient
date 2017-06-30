package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0070a {
    final /* synthetic */ b dkx;
    private final /* synthetic */ List dky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, List list) {
        this.dkx = bVar;
        this.dky = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0070a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.dky.add(it.next());
        }
    }
}
