package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements b {
    final /* synthetic */ c bdi;
    private final /* synthetic */ List bdj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, List list) {
        this.bdi = cVar;
        this.bdj = list;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.bdj.add(it.next());
        }
    }
}
