package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0062a {
    final /* synthetic */ b bWT;
    private final /* synthetic */ ImMessageCenterPojo bWV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bWT = bVar;
        this.bWV = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0062a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bWV.getLast_content_time() < next.getLast_content_time()) {
                    this.bWV.setLast_content(next.getLast_content());
                    this.bWV.setLast_content_time(next.getLast_content_time());
                    this.bWV.setLast_rid(next.getLast_rid());
                    this.bWV.setLast_user_name(next.getLast_user_name());
                    this.bWV.setSend_status(next.getSend_status());
                }
                this.bWV.setUnread_count(next.getUnread_count() + this.bWV.getUnread_count());
                this.bWV.setIs_hidden(0);
            }
        }
    }
}
