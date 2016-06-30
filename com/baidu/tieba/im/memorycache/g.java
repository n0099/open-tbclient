package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0064a {
    final /* synthetic */ b cSe;
    private final /* synthetic */ ImMessageCenterPojo cSg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cSe = bVar;
        this.cSg = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.cSg.getLast_content_time() < next.getLast_content_time()) {
                    this.cSg.setLast_content(next.getLast_content());
                    this.cSg.setLast_content_time(next.getLast_content_time());
                    this.cSg.setLast_rid(next.getLast_rid());
                    this.cSg.setLast_user_name(next.getLast_user_name());
                    this.cSg.setSend_status(next.getSend_status());
                }
                this.cSg.setUnread_count(next.getUnread_count() + this.cSg.getUnread_count());
                this.cSg.setIs_hidden(0);
            }
        }
    }
}
