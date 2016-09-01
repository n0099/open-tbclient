package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0065a {
    final /* synthetic */ b dgJ;
    private final /* synthetic */ ImMessageCenterPojo dgN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dgJ = bVar;
        this.dgN = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0065a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.dgN.getLast_content_time() < next.getLast_content_time()) {
                    this.dgN.setLast_content(next.getLast_content());
                    this.dgN.setLast_content_time(next.getLast_content_time());
                    this.dgN.setLast_rid(next.getLast_rid());
                    this.dgN.setLast_user_name(next.getLast_user_name());
                }
                this.dgN.setIs_hidden(0);
                this.dgN.setUnread_count(next.getUnread_count() + this.dgN.getUnread_count());
            }
        }
    }
}
