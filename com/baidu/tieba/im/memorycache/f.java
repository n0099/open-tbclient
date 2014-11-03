package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements b {
    final /* synthetic */ c bdi;
    private final /* synthetic */ List bdj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, List list) {
        this.bdi = cVar;
        this.bdj = list;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0) {
                this.bdj.add(next);
            }
        }
    }
}
