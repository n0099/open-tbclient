package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements b {
    final /* synthetic */ c bhS;
    private final /* synthetic */ ImMessageCenterPojo bhW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bhS = cVar;
        this.bhW = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.bhW.getLast_content_time() < next.getLast_content_time()) {
                    this.bhW.setLast_content(next.getLast_content());
                    this.bhW.setLast_content_time(next.getLast_content_time());
                    this.bhW.setLast_rid(next.getLast_rid());
                    this.bhW.setLast_user_name(next.getLast_user_name());
                }
                this.bhW.setIs_hidden(0);
                this.bhW.setUnread_count(next.getUnread_count() + this.bhW.getUnread_count());
            }
        }
    }
}
