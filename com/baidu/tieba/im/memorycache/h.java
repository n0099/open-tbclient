package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements b {
    final /* synthetic */ c bjh;
    private final /* synthetic */ ImMessageCenterPojo bjj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bjh = cVar;
        this.bjj = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bjj.getLast_content_time() < next.getLast_content_time()) {
                    this.bjj.setLast_content(next.getLast_content());
                    this.bjj.setLast_content_time(next.getLast_content_time());
                    this.bjj.setLast_rid(next.getLast_rid());
                    this.bjj.setLast_user_name(next.getLast_user_name());
                }
                this.bjj.setUnread_count(next.getUnread_count() + this.bjj.getUnread_count());
                this.bjj.setIs_hidden(0);
            }
        }
    }
}
