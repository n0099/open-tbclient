package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0067a {
    final /* synthetic */ b dnO;
    private final /* synthetic */ ImMessageCenterPojo dnQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dnO = bVar;
        this.dnQ = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0067a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.dnQ.getLast_content_time() < next.getLast_content_time()) {
                    this.dnQ.setLast_content(next.getLast_content());
                    this.dnQ.setLast_content_time(next.getLast_content_time());
                    this.dnQ.setLast_rid(next.getLast_rid());
                    this.dnQ.setLast_user_name(next.getLast_user_name());
                    this.dnQ.setSend_status(next.getSend_status());
                }
                this.dnQ.setUnread_count(next.getUnread_count() + this.dnQ.getUnread_count());
                this.dnQ.setIs_hidden(0);
            }
        }
    }
}
