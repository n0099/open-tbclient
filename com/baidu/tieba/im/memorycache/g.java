package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0065a {
    final /* synthetic */ b dcl;
    private final /* synthetic */ ImMessageCenterPojo dcn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dcl = bVar;
        this.dcn = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0065a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.dcn.getLast_content_time() < next.getLast_content_time()) {
                    this.dcn.setLast_content(next.getLast_content());
                    this.dcn.setLast_content_time(next.getLast_content_time());
                    this.dcn.setLast_rid(next.getLast_rid());
                    this.dcn.setLast_user_name(next.getLast_user_name());
                    this.dcn.setSend_status(next.getSend_status());
                }
                this.dcn.setUnread_count(next.getUnread_count() + this.dcn.getUnread_count());
                this.dcn.setIs_hidden(0);
            }
        }
    }
}
