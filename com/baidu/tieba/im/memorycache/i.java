package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0064a {
    final /* synthetic */ b dda;
    private final /* synthetic */ ImMessageCenterPojo dde;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dda = bVar;
        this.dde = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.dde.getLast_content_time() < next.getLast_content_time()) {
                    this.dde.setLast_content(next.getLast_content());
                    this.dde.setLast_content_time(next.getLast_content_time());
                    this.dde.setLast_rid(next.getLast_rid());
                    this.dde.setLast_user_name(next.getLast_user_name());
                }
                this.dde.setIs_hidden(0);
                this.dde.setUnread_count(next.getUnread_count() + this.dde.getUnread_count());
            }
        }
    }
}
