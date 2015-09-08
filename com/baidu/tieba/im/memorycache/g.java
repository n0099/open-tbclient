package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0059a {
    final /* synthetic */ b bAv;
    private final /* synthetic */ ImMessageCenterPojo bAx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bAv = bVar;
        this.bAx = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bAx.getLast_content_time() < next.getLast_content_time()) {
                    this.bAx.setLast_content(next.getLast_content());
                    this.bAx.setLast_content_time(next.getLast_content_time());
                    this.bAx.setLast_rid(next.getLast_rid());
                    this.bAx.setLast_user_name(next.getLast_user_name());
                    this.bAx.setSend_status(next.getSend_status());
                }
                this.bAx.setUnread_count(next.getUnread_count() + this.bAx.getUnread_count());
                this.bAx.setIs_hidden(0);
            }
        }
    }
}
