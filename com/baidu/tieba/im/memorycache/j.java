package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements b {
    final /* synthetic */ c bcU;
    private final /* synthetic */ ImMessageCenterPojo bcY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bcU = cVar;
        this.bcY = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0) {
                if (this.bcY.getLast_content_time() < next.getLast_content_time()) {
                    this.bcY.setLast_content(next.getLast_content());
                    this.bcY.setLast_content_time(next.getLast_content_time());
                    this.bcY.setLast_rid(next.getLast_rid());
                    this.bcY.setLast_user_name(next.getLast_user_name());
                }
                this.bcY.setIs_hidden(0);
                this.bcY.setUnread_count(next.getUnread_count() + this.bcY.getUnread_count());
            }
        }
    }
}
