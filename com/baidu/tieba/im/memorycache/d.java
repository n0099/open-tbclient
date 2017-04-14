package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0064a {
    final /* synthetic */ b daI;
    private final /* synthetic */ List daJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, List list) {
        this.daI = bVar;
        this.daJ = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.daJ.add(it.next());
        }
    }
}
