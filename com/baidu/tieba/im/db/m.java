package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements e {
    final /* synthetic */ l a;
    private final /* synthetic */ Set b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, Set set) {
        this.a = lVar;
        this.b = set;
    }

    @Override // com.baidu.tieba.im.db.e
    public final void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.b.add(it.next().getGid());
        }
    }
}
