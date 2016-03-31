package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0065a {
    final /* synthetic */ b clR;
    private final /* synthetic */ ImMessageCenterPojo clV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.clR = bVar;
        this.clV = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0065a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.clV.getLast_content_time() < next.getLast_content_time()) {
                    this.clV.setLast_content(next.getLast_content());
                    this.clV.setLast_content_time(next.getLast_content_time());
                    this.clV.setLast_rid(next.getLast_rid());
                    this.clV.setLast_user_name(next.getLast_user_name());
                }
                this.clV.setIs_hidden(0);
                this.clV.setUnread_count(next.getUnread_count() + this.clV.getUnread_count());
            }
        }
    }
}
