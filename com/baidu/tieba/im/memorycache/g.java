package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0059a {
    final /* synthetic */ b cmP;
    private final /* synthetic */ ImMessageCenterPojo cmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cmP = bVar;
        this.cmR = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.cmR.getLast_content_time() < next.getLast_content_time()) {
                    this.cmR.setLast_content(next.getLast_content());
                    this.cmR.setLast_content_time(next.getLast_content_time());
                    this.cmR.setLast_rid(next.getLast_rid());
                    this.cmR.setLast_user_name(next.getLast_user_name());
                    this.cmR.setSend_status(next.getSend_status());
                }
                this.cmR.setUnread_count(next.getUnread_count() + this.cmR.getUnread_count());
                this.cmR.setIs_hidden(0);
            }
        }
    }
}
