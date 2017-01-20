package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0066a {
    final /* synthetic */ b cZS;
    private final /* synthetic */ ImMessageCenterPojo cZU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cZS = bVar;
        this.cZU = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0066a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.cZU.getLast_content_time() < next.getLast_content_time()) {
                    this.cZU.setLast_content(next.getLast_content());
                    this.cZU.setLast_content_time(next.getLast_content_time());
                    this.cZU.setLast_rid(next.getLast_rid());
                    this.cZU.setLast_user_name(next.getLast_user_name());
                    this.cZU.setSend_status(next.getSend_status());
                }
                this.cZU.setUnread_count(next.getUnread_count() + this.cZU.getUnread_count());
                this.cZU.setIs_hidden(0);
            }
        }
    }
}
