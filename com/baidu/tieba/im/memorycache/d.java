package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0065a {
    final /* synthetic */ b dgJ;
    private final /* synthetic */ List dgK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, List list) {
        this.dgJ = bVar;
        this.dgK = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0065a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.dgK.add(it.next());
        }
    }
}
