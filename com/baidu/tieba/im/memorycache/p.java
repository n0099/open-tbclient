package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements a.InterfaceC0067a {
    final /* synthetic */ b bTj;
    private final /* synthetic */ List bTk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(b bVar, List list) {
        this.bTj = bVar;
        this.bTk = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0067a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.bTk.add(it.next());
        }
    }
}
