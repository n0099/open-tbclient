package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements a.InterfaceC0059a {
    final /* synthetic */ b cmP;
    private final /* synthetic */ List cmQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(b bVar, List list) {
        this.cmP = bVar;
        this.cmQ = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.cmQ.add(it.next());
        }
    }
}
