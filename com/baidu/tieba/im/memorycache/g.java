package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0070a {
    final /* synthetic */ b dkx;
    private final /* synthetic */ ImMessageCenterPojo dkz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dkx = bVar;
        this.dkz = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0070a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.dkz.getLast_content_time() < next.getLast_content_time()) {
                    this.dkz.setLast_content(next.getLast_content());
                    this.dkz.setLast_content_time(next.getLast_content_time());
                    this.dkz.setLast_rid(next.getLast_rid());
                    this.dkz.setLast_user_name(next.getLast_user_name());
                    this.dkz.setSend_status(next.getSend_status());
                }
                this.dkz.setUnread_count(next.getUnread_count() + this.dkz.getUnread_count());
                this.dkz.setIs_hidden(0);
            }
        }
    }
}
