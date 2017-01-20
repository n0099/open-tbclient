package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.Iterator;
import java.util.List;
import protobuf.NewpushRepair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0066a {
    final /* synthetic */ b cZS;
    private final /* synthetic */ List cZY;
    private final /* synthetic */ NewpushRepair.Builder cZZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar, List list, NewpushRepair.Builder builder) {
        this.cZS = bVar;
        this.cZY = list;
        this.cZZ = builder;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0066a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            long c = com.baidu.adp.lib.g.b.c(next.getGid(), 0L);
            long sid = next.getSid();
            if (sid > 0) {
                this.cZY.add(MessageUtils.makeNewpushGroupRepair(c, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.g.bM(next.getPulled_msgId())));
            }
        }
        if (this.cZY.size() <= 10) {
            this.cZZ.groups = this.cZY;
            return;
        }
        this.cZZ.followType = "0";
    }
}
