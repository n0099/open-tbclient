package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0064a {
    final /* synthetic */ b cUZ;
    private final /* synthetic */ ImMessageCenterPojo cVd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cUZ = bVar;
        this.cVd = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.cVd.getLast_content_time() < next.getLast_content_time()) {
                    this.cVd.setLast_content(next.getLast_content());
                    this.cVd.setLast_content_time(next.getLast_content_time());
                    this.cVd.setLast_rid(next.getLast_rid());
                    this.cVd.setLast_user_name(next.getLast_user_name());
                }
                this.cVd.setIs_hidden(0);
                this.cVd.setUnread_count(next.getUnread_count() + this.cVd.getUnread_count());
            }
        }
    }
}
