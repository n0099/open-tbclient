package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.Iterator;
import java.util.List;
import protobuf.NewpushRepair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0064a {
    final /* synthetic */ b dda;
    private final /* synthetic */ List ddg;
    private final /* synthetic */ NewpushRepair.Builder ddh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar, List list, NewpushRepair.Builder builder) {
        this.dda = bVar;
        this.ddg = list;
        this.ddh = builder;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            long c = com.baidu.adp.lib.g.b.c(next.getGid(), 0L);
            long sid = next.getSid();
            if (sid > 0) {
                this.ddg.add(MessageUtils.makeNewpushGroupRepair(c, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.g.bN(next.getPulled_msgId())));
            }
        }
        if (this.ddg.size() <= 10) {
            this.ddh.groups = this.ddg;
            return;
        }
        this.ddh.followType = "0";
    }
}
