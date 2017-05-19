package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.Iterator;
import java.util.List;
import protobuf.NewpushRepair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0068a {
    final /* synthetic */ b cXb;
    private final /* synthetic */ List cXh;
    private final /* synthetic */ NewpushRepair.Builder cXi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar, List list, NewpushRepair.Builder builder) {
        this.cXb = bVar;
        this.cXh = list;
        this.cXi = builder;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0068a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            long c = com.baidu.adp.lib.g.b.c(next.getGid(), 0L);
            long sid = next.getSid();
            if (sid > 0) {
                this.cXh.add(MessageUtils.makeNewpushGroupRepair(c, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.g.by(next.getPulled_msgId())));
            }
        }
        if (this.cXh.size() <= 10) {
            this.cXi.groups = this.cXh;
            return;
        }
        this.cXi.followType = "0";
    }
}
