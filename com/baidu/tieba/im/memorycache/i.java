package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0067a {
    final /* synthetic */ b dnO;
    private final /* synthetic */ ImMessageCenterPojo dnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dnO = bVar;
        this.dnS = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0067a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.dnS.getLast_content_time() < next.getLast_content_time()) {
                    this.dnS.setLast_content(next.getLast_content());
                    this.dnS.setLast_content_time(next.getLast_content_time());
                    this.dnS.setLast_rid(next.getLast_rid());
                    this.dnS.setLast_user_name(next.getLast_user_name());
                }
                this.dnS.setIs_hidden(0);
                this.dnS.setUnread_count(next.getUnread_count() + this.dnS.getUnread_count());
            }
        }
    }
}
