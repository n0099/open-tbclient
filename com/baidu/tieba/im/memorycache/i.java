package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0059a {
    final /* synthetic */ b bEd;
    private final /* synthetic */ ImMessageCenterPojo bEh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bEd = bVar;
        this.bEh = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.bEh.getLast_content_time() < next.getLast_content_time()) {
                    this.bEh.setLast_content(next.getLast_content());
                    this.bEh.setLast_content_time(next.getLast_content_time());
                    this.bEh.setLast_rid(next.getLast_rid());
                    this.bEh.setLast_user_name(next.getLast_user_name());
                }
                this.bEh.setIs_hidden(0);
                this.bEh.setUnread_count(next.getUnread_count() + this.bEh.getUnread_count());
            }
        }
    }
}
