package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements b {
    final /* synthetic */ c bma;
    private final /* synthetic */ ImMessageCenterPojo bme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bma = cVar;
        this.bme = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.bme.getLast_content_time() < next.getLast_content_time()) {
                    this.bme.setLast_content(next.getLast_content());
                    this.bme.setLast_content_time(next.getLast_content_time());
                    this.bme.setLast_rid(next.getLast_rid());
                    this.bme.setLast_user_name(next.getLast_user_name());
                }
                this.bme.setIs_hidden(0);
                this.bme.setUnread_count(next.getUnread_count() + this.bme.getUnread_count());
            }
        }
    }
}
