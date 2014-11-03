package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements b {
    final /* synthetic */ c bdi;
    private final /* synthetic */ ImMessageCenterPojo bdm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bdi = cVar;
        this.bdm = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0) {
                if (this.bdm.getLast_content_time() < next.getLast_content_time()) {
                    this.bdm.setLast_content(next.getLast_content());
                    this.bdm.setLast_content_time(next.getLast_content_time());
                    this.bdm.setLast_rid(next.getLast_rid());
                    this.bdm.setLast_user_name(next.getLast_user_name());
                }
                this.bdm.setIs_hidden(0);
                this.bdm.setUnread_count(next.getUnread_count() + this.bdm.getUnread_count());
            }
        }
    }
}
