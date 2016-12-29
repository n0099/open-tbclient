package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0064a {
    final /* synthetic */ b cSK;
    private final /* synthetic */ ImMessageCenterPojo cSM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cSK = bVar;
        this.cSM = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.cSM.getLast_content_time() < next.getLast_content_time()) {
                    this.cSM.setLast_content(next.getLast_content());
                    this.cSM.setLast_content_time(next.getLast_content_time());
                    this.cSM.setLast_rid(next.getLast_rid());
                    this.cSM.setLast_user_name(next.getLast_user_name());
                    this.cSM.setSend_status(next.getSend_status());
                }
                this.cSM.setUnread_count(next.getUnread_count() + this.cSM.getUnread_count());
                this.cSM.setIs_hidden(0);
            }
        }
    }
}
