package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.Iterator;
import java.util.List;
import protobuf.NewpushRepair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0067a {
    final /* synthetic */ b dcA;
    private final /* synthetic */ List dcG;
    private final /* synthetic */ NewpushRepair.Builder dcH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar, List list, NewpushRepair.Builder builder) {
        this.dcA = bVar;
        this.dcG = list;
        this.dcH = builder;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0067a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            long c = com.baidu.adp.lib.g.b.c(next.getGid(), 0L);
            long sid = next.getSid();
            if (sid > 0) {
                this.dcG.add(MessageUtils.makeNewpushGroupRepair(c, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.g.bB(next.getPulled_msgId())));
            }
        }
        if (this.dcG.size() <= 10) {
            this.dcH.groups = this.dcG;
            return;
        }
        this.dcH.followType = "0";
    }
}
