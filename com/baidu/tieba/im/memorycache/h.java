package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements b {
    final /* synthetic */ c bma;
    private final /* synthetic */ ImMessageCenterPojo bmc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bma = cVar;
        this.bmc = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bmc.getLast_content_time() < next.getLast_content_time()) {
                    this.bmc.setLast_content(next.getLast_content());
                    this.bmc.setLast_content_time(next.getLast_content_time());
                    this.bmc.setLast_rid(next.getLast_rid());
                    this.bmc.setLast_user_name(next.getLast_user_name());
                }
                this.bmc.setUnread_count(next.getUnread_count() + this.bmc.getUnread_count());
                this.bmc.setIs_hidden(0);
            }
        }
    }
}
