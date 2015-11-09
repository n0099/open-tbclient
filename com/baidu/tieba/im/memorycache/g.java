package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0059a {
    final /* synthetic */ b bEd;
    private final /* synthetic */ ImMessageCenterPojo bEf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bEd = bVar;
        this.bEf = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bEf.getLast_content_time() < next.getLast_content_time()) {
                    this.bEf.setLast_content(next.getLast_content());
                    this.bEf.setLast_content_time(next.getLast_content_time());
                    this.bEf.setLast_rid(next.getLast_rid());
                    this.bEf.setLast_user_name(next.getLast_user_name());
                    this.bEf.setSend_status(next.getSend_status());
                }
                this.bEf.setUnread_count(next.getUnread_count() + this.bEf.getUnread_count());
                this.bEf.setIs_hidden(0);
            }
        }
    }
}
