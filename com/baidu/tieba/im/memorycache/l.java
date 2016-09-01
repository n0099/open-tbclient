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
    final /* synthetic */ b dgJ;
    private final /* synthetic */ List dgP;
    private final /* synthetic */ NewpushRepair.Builder dgQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar, List list, NewpushRepair.Builder builder) {
        this.dgJ = bVar;
        this.dgP = list;
        this.dgQ = builder;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0065a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            long c = com.baidu.adp.lib.h.b.c(next.getGid(), 0L);
            long sid = next.getSid();
            if (sid > 0) {
                this.dgP.add(MessageUtils.makeNewpushGroupRepair(c, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.g.ce(next.getPulled_msgId())));
            }
        }
        if (this.dgP.size() <= 10) {
            this.dgQ.groups = this.dgP;
            return;
        }
        this.dgQ.followType = "0";
    }
}
