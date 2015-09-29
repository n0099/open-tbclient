package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0059a {
    private final /* synthetic */ ImMessageCenterPojo bDB;
    final /* synthetic */ b bDx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bDx = bVar;
        this.bDB = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.bDB.getLast_content_time() < next.getLast_content_time()) {
                    this.bDB.setLast_content(next.getLast_content());
                    this.bDB.setLast_content_time(next.getLast_content_time());
                    this.bDB.setLast_rid(next.getLast_rid());
                    this.bDB.setLast_user_name(next.getLast_user_name());
                }
                this.bDB.setIs_hidden(0);
                this.bDB.setUnread_count(next.getUnread_count() + this.bDB.getUnread_count());
            }
        }
    }
}
