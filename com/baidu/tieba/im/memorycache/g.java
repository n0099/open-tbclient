package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0068a {
    final /* synthetic */ b cXb;
    private final /* synthetic */ ImMessageCenterPojo cXd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cXb = bVar;
        this.cXd = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0068a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.cXd.getLast_content_time() < next.getLast_content_time()) {
                    this.cXd.setLast_content(next.getLast_content());
                    this.cXd.setLast_content_time(next.getLast_content_time());
                    this.cXd.setLast_rid(next.getLast_rid());
                    this.cXd.setLast_user_name(next.getLast_user_name());
                    this.cXd.setSend_status(next.getSend_status());
                }
                this.cXd.setUnread_count(next.getUnread_count() + this.cXd.getUnread_count());
                this.cXd.setIs_hidden(0);
            }
        }
    }
}
