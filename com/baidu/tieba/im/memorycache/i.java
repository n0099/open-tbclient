package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0065a {
    final /* synthetic */ b dcl;
    private final /* synthetic */ ImMessageCenterPojo dcp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dcl = bVar;
        this.dcp = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0065a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.dcp.getLast_content_time() < next.getLast_content_time()) {
                    this.dcp.setLast_content(next.getLast_content());
                    this.dcp.setLast_content_time(next.getLast_content_time());
                    this.dcp.setLast_rid(next.getLast_rid());
                    this.dcp.setLast_user_name(next.getLast_user_name());
                }
                this.dcp.setIs_hidden(0);
                this.dcp.setUnread_count(next.getUnread_count() + this.dcp.getUnread_count());
            }
        }
    }
}
