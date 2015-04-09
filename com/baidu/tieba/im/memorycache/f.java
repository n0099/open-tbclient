package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements b {
    final /* synthetic */ c bjx;
    private final /* synthetic */ List bjy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar, List list) {
        this.bjx = cVar;
        this.bjy = list;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0) {
                this.bjy.add(next);
            }
        }
    }
}
