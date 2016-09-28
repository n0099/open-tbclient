package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0068a {
    final /* synthetic */ b dig;
    private final /* synthetic */ ImMessageCenterPojo dik;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dig = bVar;
        this.dik = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0068a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.dik.getLast_content_time() < next.getLast_content_time()) {
                    this.dik.setLast_content(next.getLast_content());
                    this.dik.setLast_content_time(next.getLast_content_time());
                    this.dik.setLast_rid(next.getLast_rid());
                    this.dik.setLast_user_name(next.getLast_user_name());
                }
                this.dik.setIs_hidden(0);
                this.dik.setUnread_count(next.getUnread_count() + this.dik.getUnread_count());
            }
        }
    }
}
