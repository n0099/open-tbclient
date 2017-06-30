package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.Iterator;
import java.util.List;
import protobuf.NewpushRepair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0070a {
    private final /* synthetic */ List dkD;
    private final /* synthetic */ NewpushRepair.Builder dkE;
    final /* synthetic */ b dkx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar, List list, NewpushRepair.Builder builder) {
        this.dkx = bVar;
        this.dkD = list;
        this.dkE = builder;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0070a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            long c = com.baidu.adp.lib.g.b.c(next.getGid(), 0L);
            long sid = next.getSid();
            if (sid > 0) {
                this.dkD.add(MessageUtils.makeNewpushGroupRepair(c, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.g.bP(next.getPulled_msgId())));
            }
        }
        if (this.dkD.size() <= 10) {
            this.dkE.groups = this.dkD;
            return;
        }
        this.dkE.followType = "0";
    }
}
