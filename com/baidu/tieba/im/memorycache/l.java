package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.Iterator;
import java.util.List;
import protobuf.NewpushRepair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0059a {
    final /* synthetic */ b cmP;
    private final /* synthetic */ List cmV;
    private final /* synthetic */ NewpushRepair.Builder cmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar, List list, NewpushRepair.Builder builder) {
        this.cmP = bVar;
        this.cmV = list;
        this.cmW = builder;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            long c = com.baidu.adp.lib.h.b.c(next.getGid(), 0L);
            long sid = next.getSid();
            if (sid > 0) {
                this.cmV.add(MessageUtils.makeNewpushGroupRepair(c, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.g.bl(next.getPulled_msgId())));
            }
        }
        if (this.cmV.size() <= 10) {
            this.cmW.groups = this.cmV;
            return;
        }
        this.cmW.followType = "0";
    }
}
