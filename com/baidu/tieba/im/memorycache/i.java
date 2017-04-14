package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0064a {
    final /* synthetic */ b daI;
    private final /* synthetic */ ImMessageCenterPojo daM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.daI = bVar;
        this.daM = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.daM.getLast_content_time() < next.getLast_content_time()) {
                    this.daM.setLast_content(next.getLast_content());
                    this.daM.setLast_content_time(next.getLast_content_time());
                    this.daM.setLast_rid(next.getLast_rid());
                    this.daM.setLast_user_name(next.getLast_user_name());
                }
                this.daM.setIs_hidden(0);
                this.daM.setUnread_count(next.getUnread_count() + this.daM.getUnread_count());
            }
        }
    }
}
