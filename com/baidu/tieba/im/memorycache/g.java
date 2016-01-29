package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0064a {
    final /* synthetic */ b cbn;
    private final /* synthetic */ ImMessageCenterPojo cbp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cbn = bVar;
        this.cbp = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.cbp.getLast_content_time() < next.getLast_content_time()) {
                    this.cbp.setLast_content(next.getLast_content());
                    this.cbp.setLast_content_time(next.getLast_content_time());
                    this.cbp.setLast_rid(next.getLast_rid());
                    this.cbp.setLast_user_name(next.getLast_user_name());
                    this.cbp.setSend_status(next.getSend_status());
                }
                this.cbp.setUnread_count(next.getUnread_count() + this.cbp.getUnread_count());
                this.cbp.setIs_hidden(0);
            }
        }
    }
}
