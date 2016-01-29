package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0064a {
    final /* synthetic */ b cbn;
    private final /* synthetic */ ImMessageCenterPojo cbr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cbn = bVar;
        this.cbr = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.cbr.getLast_content_time() < next.getLast_content_time()) {
                    this.cbr.setLast_content(next.getLast_content());
                    this.cbr.setLast_content_time(next.getLast_content_time());
                    this.cbr.setLast_rid(next.getLast_rid());
                    this.cbr.setLast_user_name(next.getLast_user_name());
                }
                this.cbr.setIs_hidden(0);
                this.cbr.setUnread_count(next.getUnread_count() + this.cbr.getUnread_count());
            }
        }
    }
}
