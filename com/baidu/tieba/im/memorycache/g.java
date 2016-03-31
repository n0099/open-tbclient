package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0065a {
    final /* synthetic */ b clR;
    private final /* synthetic */ ImMessageCenterPojo clT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.clR = bVar;
        this.clT = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0065a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.clT.getLast_content_time() < next.getLast_content_time()) {
                    this.clT.setLast_content(next.getLast_content());
                    this.clT.setLast_content_time(next.getLast_content_time());
                    this.clT.setLast_rid(next.getLast_rid());
                    this.clT.setLast_user_name(next.getLast_user_name());
                    this.clT.setSend_status(next.getSend_status());
                }
                this.clT.setUnread_count(next.getUnread_count() + this.clT.getUnread_count());
                this.clT.setIs_hidden(0);
            }
        }
    }
}
