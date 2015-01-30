package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements b {
    final /* synthetic */ c bhS;
    private final /* synthetic */ ImMessageCenterPojo bhU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bhS = cVar;
        this.bhU = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bhU.getLast_content_time() < next.getLast_content_time()) {
                    this.bhU.setLast_content(next.getLast_content());
                    this.bhU.setLast_content_time(next.getLast_content_time());
                    this.bhU.setLast_rid(next.getLast_rid());
                    this.bhU.setLast_user_name(next.getLast_user_name());
                }
                this.bhU.setUnread_count(next.getUnread_count() + this.bhU.getUnread_count());
                this.bhU.setIs_hidden(0);
            }
        }
    }
}
