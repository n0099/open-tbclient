package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements a.InterfaceC0067a {
    final /* synthetic */ b dnO;
    private final /* synthetic */ List dnP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(b bVar, List list) {
        this.dnO = bVar;
        this.dnP = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0067a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.dnP.add(it.next());
        }
    }
}
