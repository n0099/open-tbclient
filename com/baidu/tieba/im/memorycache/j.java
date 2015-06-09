package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements b {
    final /* synthetic */ c bmb;
    private final /* synthetic */ ImMessageCenterPojo bmf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bmb = cVar;
        this.bmf = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.bmf.getLast_content_time() < next.getLast_content_time()) {
                    this.bmf.setLast_content(next.getLast_content());
                    this.bmf.setLast_content_time(next.getLast_content_time());
                    this.bmf.setLast_rid(next.getLast_rid());
                    this.bmf.setLast_user_name(next.getLast_user_name());
                }
                this.bmf.setIs_hidden(0);
                this.bmf.setUnread_count(next.getUnread_count() + this.bmf.getUnread_count());
            }
        }
    }
}
