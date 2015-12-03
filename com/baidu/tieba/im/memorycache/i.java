package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0067a {
    final /* synthetic */ b bTj;
    private final /* synthetic */ ImMessageCenterPojo bTn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bTj = bVar;
        this.bTn = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0067a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.bTn.getLast_content_time() < next.getLast_content_time()) {
                    this.bTn.setLast_content(next.getLast_content());
                    this.bTn.setLast_content_time(next.getLast_content_time());
                    this.bTn.setLast_rid(next.getLast_rid());
                    this.bTn.setLast_user_name(next.getLast_user_name());
                }
                this.bTn.setIs_hidden(0);
                this.bTn.setUnread_count(next.getUnread_count() + this.bTn.getUnread_count());
            }
        }
    }
}
