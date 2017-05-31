package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0067a {
    final /* synthetic */ b dcA;
    private final /* synthetic */ ImMessageCenterPojo dcE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dcA = bVar;
        this.dcE = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0067a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.dcE.getLast_content_time() < next.getLast_content_time()) {
                    this.dcE.setLast_content(next.getLast_content());
                    this.dcE.setLast_content_time(next.getLast_content_time());
                    this.dcE.setLast_rid(next.getLast_rid());
                    this.dcE.setLast_user_name(next.getLast_user_name());
                }
                this.dcE.setIs_hidden(0);
                this.dcE.setUnread_count(next.getUnread_count() + this.dcE.getUnread_count());
            }
        }
    }
}
