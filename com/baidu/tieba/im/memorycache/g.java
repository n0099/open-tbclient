package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0064a {
    final /* synthetic */ b dda;
    private final /* synthetic */ ImMessageCenterPojo ddc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dda = bVar;
        this.ddc = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.ddc.getLast_content_time() < next.getLast_content_time()) {
                    this.ddc.setLast_content(next.getLast_content());
                    this.ddc.setLast_content_time(next.getLast_content_time());
                    this.ddc.setLast_rid(next.getLast_rid());
                    this.ddc.setLast_user_name(next.getLast_user_name());
                    this.ddc.setSend_status(next.getSend_status());
                }
                this.ddc.setUnread_count(next.getUnread_count() + this.ddc.getUnread_count());
                this.ddc.setIs_hidden(0);
            }
        }
    }
}
