package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements b {
    final /* synthetic */ c bjx;
    private final /* synthetic */ ImMessageCenterPojo bjz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bjx = cVar;
        this.bjz = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bjz.getLast_content_time() < next.getLast_content_time()) {
                    this.bjz.setLast_content(next.getLast_content());
                    this.bjz.setLast_content_time(next.getLast_content_time());
                    this.bjz.setLast_rid(next.getLast_rid());
                    this.bjz.setLast_user_name(next.getLast_user_name());
                }
                this.bjz.setUnread_count(next.getUnread_count() + this.bjz.getUnread_count());
                this.bjz.setIs_hidden(0);
            }
        }
    }
}
