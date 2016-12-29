package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0064a {
    final /* synthetic */ b cSK;
    private final /* synthetic */ ImMessageCenterPojo cSO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cSK = bVar;
        this.cSO = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.cSO.getLast_content_time() < next.getLast_content_time()) {
                    this.cSO.setLast_content(next.getLast_content());
                    this.cSO.setLast_content_time(next.getLast_content_time());
                    this.cSO.setLast_rid(next.getLast_rid());
                    this.cSO.setLast_user_name(next.getLast_user_name());
                }
                this.cSO.setIs_hidden(0);
                this.cSO.setUnread_count(next.getUnread_count() + this.cSO.getUnread_count());
            }
        }
    }
}
