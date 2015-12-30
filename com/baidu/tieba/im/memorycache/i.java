package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0062a {
    final /* synthetic */ b bWT;
    private final /* synthetic */ ImMessageCenterPojo bWX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bWT = bVar;
        this.bWX = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0062a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.bWX.getLast_content_time() < next.getLast_content_time()) {
                    this.bWX.setLast_content(next.getLast_content());
                    this.bWX.setLast_content_time(next.getLast_content_time());
                    this.bWX.setLast_rid(next.getLast_rid());
                    this.bWX.setLast_user_name(next.getLast_user_name());
                }
                this.bWX.setIs_hidden(0);
                this.bWX.setUnread_count(next.getUnread_count() + this.bWX.getUnread_count());
            }
        }
    }
}
