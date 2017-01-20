package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0066a {
    final /* synthetic */ b cZS;
    private final /* synthetic */ ImMessageCenterPojo cZW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cZS = bVar;
        this.cZW = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0066a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.cZW.getLast_content_time() < next.getLast_content_time()) {
                    this.cZW.setLast_content(next.getLast_content());
                    this.cZW.setLast_content_time(next.getLast_content_time());
                    this.cZW.setLast_rid(next.getLast_rid());
                    this.cZW.setLast_user_name(next.getLast_user_name());
                }
                this.cZW.setIs_hidden(0);
                this.cZW.setUnread_count(next.getUnread_count() + this.cZW.getUnread_count());
            }
        }
    }
}
