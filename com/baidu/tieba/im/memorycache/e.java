package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements b {
    final /* synthetic */ c a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, List list) {
        this.a = cVar;
        this.b = list;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.b.add(it.next());
        }
    }
}
