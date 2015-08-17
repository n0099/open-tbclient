package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0059a {
    final /* synthetic */ b bzO;
    private final /* synthetic */ ImMessageCenterPojo bzQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bzO = bVar;
        this.bzQ = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bzQ.getLast_content_time() < next.getLast_content_time()) {
                    this.bzQ.setLast_content(next.getLast_content());
                    this.bzQ.setLast_content_time(next.getLast_content_time());
                    this.bzQ.setLast_rid(next.getLast_rid());
                    this.bzQ.setLast_user_name(next.getLast_user_name());
                    this.bzQ.setSend_status(next.getSend_status());
                }
                this.bzQ.setUnread_count(next.getUnread_count() + this.bzQ.getUnread_count());
                this.bzQ.setIs_hidden(0);
            }
        }
    }
}
