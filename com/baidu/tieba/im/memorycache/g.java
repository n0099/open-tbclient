package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements b {
    final /* synthetic */ c bma;
    private final /* synthetic */ List bmb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar, List list) {
        this.bma = cVar;
        this.bmb = list;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 1 && next.getIs_hidden() == 0) {
                this.bmb.add(next);
            }
        }
    }
}
