package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements b {
    final /* synthetic */ c bgA;
    private final /* synthetic */ ImMessageCenterPojo bgC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bgA = cVar;
        this.bgC = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bgC.getLast_content_time() < next.getLast_content_time()) {
                    this.bgC.setLast_content(next.getLast_content());
                    this.bgC.setLast_content_time(next.getLast_content_time());
                    this.bgC.setLast_rid(next.getLast_rid());
                    this.bgC.setLast_user_name(next.getLast_user_name());
                }
                this.bgC.setUnread_count(next.getUnread_count() + this.bgC.getUnread_count());
                this.bgC.setIs_hidden(0);
            }
        }
    }
}
