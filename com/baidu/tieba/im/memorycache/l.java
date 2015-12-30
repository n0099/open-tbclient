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
public class l implements a.InterfaceC0062a {
    final /* synthetic */ b bWT;
    private final /* synthetic */ List bWZ;
    private final /* synthetic */ NewpushRepair.Builder bXa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(b bVar, List list, NewpushRepair.Builder builder) {
        this.bWT = bVar;
        this.bWZ = list;
        this.bXa = builder;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0062a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            long c = com.baidu.adp.lib.h.b.c(next.getGid(), 0L);
            long sid = next.getSid();
            if (sid > 0) {
                BdLog.e("gid " + c + ", userType " + next.getUserType() + ", startSid " + sid);
                this.bWZ.add(MessageUtils.makeNewpushGroupRepair(c, next.getUserType(), sid, 0L, com.baidu.tieba.im.util.g.bd(next.getPulled_msgId())));
            }
        }
        if (this.bWZ.size() <= 10) {
            this.bXa.groups = this.bWZ;
            return;
        }
        this.bXa.followType = "0";
    }
}
