package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0070a {
    private final /* synthetic */ ImMessageCenterPojo dkB;
    final /* synthetic */ b dkx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dkx = bVar;
        this.dkB = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0070a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.dkB.getLast_content_time() < next.getLast_content_time()) {
                    this.dkB.setLast_content(next.getLast_content());
                    this.dkB.setLast_content_time(next.getLast_content_time());
                    this.dkB.setLast_rid(next.getLast_rid());
                    this.dkB.setLast_user_name(next.getLast_user_name());
                }
                this.dkB.setIs_hidden(0);
                this.dkB.setUnread_count(next.getUnread_count() + this.dkB.getUnread_count());
            }
        }
    }
}
