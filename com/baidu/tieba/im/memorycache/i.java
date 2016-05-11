package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0059a {
    final /* synthetic */ b cmP;
    private final /* synthetic */ ImMessageCenterPojo cmT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cmP = bVar;
        this.cmT = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.cmT.getLast_content_time() < next.getLast_content_time()) {
                    this.cmT.setLast_content(next.getLast_content());
                    this.cmT.setLast_content_time(next.getLast_content_time());
                    this.cmT.setLast_rid(next.getLast_rid());
                    this.cmT.setLast_user_name(next.getLast_user_name());
                }
                this.cmT.setIs_hidden(0);
                this.cmT.setUnread_count(next.getUnread_count() + this.cmT.getUnread_count());
            }
        }
    }
}
