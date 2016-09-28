package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0068a {
    final /* synthetic */ b dig;
    private final /* synthetic */ ImMessageCenterPojo dii;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dig = bVar;
        this.dii = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0068a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.dii.getLast_content_time() < next.getLast_content_time()) {
                    this.dii.setLast_content(next.getLast_content());
                    this.dii.setLast_content_time(next.getLast_content_time());
                    this.dii.setLast_rid(next.getLast_rid());
                    this.dii.setLast_user_name(next.getLast_user_name());
                    this.dii.setSend_status(next.getSend_status());
                }
                this.dii.setUnread_count(next.getUnread_count() + this.dii.getUnread_count());
                this.dii.setIs_hidden(0);
            }
        }
    }
}
