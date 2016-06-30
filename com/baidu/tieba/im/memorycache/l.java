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
    final /* synthetic */ b cSe;
    private final /* synthetic */ List cSk;
    private final /* synthetic */ NewpushRepair.Builder cSl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar, List list, NewpushRepair.Builder builder) {
        this.cSe = bVar;
        this.cSk = list;
        this.cSl = builder;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            long c = com.baidu.adp.lib.h.b.c(next.getGid(), 0L);
            long sid = next.getSid();
            if (sid > 0) {
                this.cSk.add(MessageUtils.makeNewpushGroupRepair(c, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.g.bN(next.getPulled_msgId())));
            }
        }
        if (this.cSk.size() <= 10) {
            this.cSl.groups = this.cSk;
            return;
        }
        this.cSl.followType = "0";
    }
}
