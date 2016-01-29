package com.baidu.tieba.im.memorycache;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.Iterator;
import java.util.List;
import protobuf.NewpushRepair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0064a {
    final /* synthetic */ b cbn;
    private final /* synthetic */ List cbt;
    private final /* synthetic */ NewpushRepair.Builder cbu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar, List list, NewpushRepair.Builder builder) {
        this.cbn = bVar;
        this.cbt = list;
        this.cbu = builder;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            long c = com.baidu.adp.lib.h.b.c(next.getGid(), 0L);
            long sid = next.getSid();
            if (sid > 0) {
                BdLog.e("gid " + c + ", userType " + next.getUserType() + ", startSid " + sid);
                this.cbt.add(MessageUtils.makeNewpushGroupRepair(c, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.g.bf(next.getPulled_msgId())));
            }
        }
        if (this.cbt.size() <= 10) {
            this.cbu.groups = this.cbt;
            return;
        }
        this.cbu.followType = "0";
    }
}
