package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0059a {
    final /* synthetic */ b bDx;
    private final /* synthetic */ ImMessageCenterPojo bDz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bDx = bVar;
        this.bDz = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bDz.getLast_content_time() < next.getLast_content_time()) {
                    this.bDz.setLast_content(next.getLast_content());
                    this.bDz.setLast_content_time(next.getLast_content_time());
                    this.bDz.setLast_rid(next.getLast_rid());
                    this.bDz.setLast_user_name(next.getLast_user_name());
                    this.bDz.setSend_status(next.getSend_status());
                }
                this.bDz.setUnread_count(next.getUnread_count() + this.bDz.getUnread_count());
                this.bDz.setIs_hidden(0);
            }
        }
    }
}
