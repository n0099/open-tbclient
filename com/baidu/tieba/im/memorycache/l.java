package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.Iterator;
import java.util.List;
import protobuf.NewpushRepair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0065a {
    final /* synthetic */ b clR;
    private final /* synthetic */ List clX;
    private final /* synthetic */ NewpushRepair.Builder clY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar, List list, NewpushRepair.Builder builder) {
        this.clR = bVar;
        this.clX = list;
        this.clY = builder;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0065a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            long c = com.baidu.adp.lib.h.b.c(next.getGid(), 0L);
            long sid = next.getSid();
            if (sid > 0) {
                this.clX.add(MessageUtils.makeNewpushGroupRepair(c, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.g.bl(next.getPulled_msgId())));
            }
        }
        if (this.clX.size() <= 10) {
            this.clY.groups = this.clX;
            return;
        }
        this.clY.followType = "0";
    }
}
