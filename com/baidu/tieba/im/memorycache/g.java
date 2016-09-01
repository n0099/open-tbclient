package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0065a {
    final /* synthetic */ b dgJ;
    private final /* synthetic */ ImMessageCenterPojo dgL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dgJ = bVar;
        this.dgL = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0065a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.dgL.getLast_content_time() < next.getLast_content_time()) {
                    this.dgL.setLast_content(next.getLast_content());
                    this.dgL.setLast_content_time(next.getLast_content_time());
                    this.dgL.setLast_rid(next.getLast_rid());
                    this.dgL.setLast_user_name(next.getLast_user_name());
                    this.dgL.setSend_status(next.getSend_status());
                }
                this.dgL.setUnread_count(next.getUnread_count() + this.dgL.getUnread_count());
                this.dgL.setIs_hidden(0);
            }
        }
    }
}
