package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements b {
    final /* synthetic */ c bdi;
    private final /* synthetic */ ImMessageCenterPojo bdk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bdi = cVar;
        this.bdk = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bdk.getLast_content_time() < next.getLast_content_time()) {
                    this.bdk.setLast_content(next.getLast_content());
                    this.bdk.setLast_content_time(next.getLast_content_time());
                    this.bdk.setLast_rid(next.getLast_rid());
                    this.bdk.setLast_user_name(next.getLast_user_name());
                }
                this.bdk.setUnread_count(next.getUnread_count() + this.bdk.getUnread_count());
                this.bdk.setIs_hidden(0);
            }
        }
    }
}
