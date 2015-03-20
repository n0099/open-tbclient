package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements b {
    final /* synthetic */ c bjh;
    private final /* synthetic */ ImMessageCenterPojo bjl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bjh = cVar;
        this.bjl = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.bjl.getLast_content_time() < next.getLast_content_time()) {
                    this.bjl.setLast_content(next.getLast_content());
                    this.bjl.setLast_content_time(next.getLast_content_time());
                    this.bjl.setLast_rid(next.getLast_rid());
                    this.bjl.setLast_user_name(next.getLast_user_name());
                }
                this.bjl.setIs_hidden(0);
                this.bjl.setUnread_count(next.getUnread_count() + this.bjl.getUnread_count());
            }
        }
    }
}
