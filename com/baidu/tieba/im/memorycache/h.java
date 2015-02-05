package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements b {
    final /* synthetic */ c bhR;
    private final /* synthetic */ ImMessageCenterPojo bhT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bhR = cVar;
        this.bhT = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bhT.getLast_content_time() < next.getLast_content_time()) {
                    this.bhT.setLast_content(next.getLast_content());
                    this.bhT.setLast_content_time(next.getLast_content_time());
                    this.bhT.setLast_rid(next.getLast_rid());
                    this.bhT.setLast_user_name(next.getLast_user_name());
                }
                this.bhT.setUnread_count(next.getUnread_count() + this.bhT.getUnread_count());
                this.bhT.setIs_hidden(0);
            }
        }
    }
}
