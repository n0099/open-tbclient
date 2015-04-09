package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements b {
    private final /* synthetic */ ImMessageCenterPojo bjB;
    final /* synthetic */ c bjx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bjx = cVar;
        this.bjB = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.bjB.getLast_content_time() < next.getLast_content_time()) {
                    this.bjB.setLast_content(next.getLast_content());
                    this.bjB.setLast_content_time(next.getLast_content_time());
                    this.bjB.setLast_rid(next.getLast_rid());
                    this.bjB.setLast_user_name(next.getLast_user_name());
                }
                this.bjB.setIs_hidden(0);
                this.bjB.setUnread_count(next.getUnread_count() + this.bjB.getUnread_count());
            }
        }
    }
}
