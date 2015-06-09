package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements b {
    final /* synthetic */ c bmb;
    private final /* synthetic */ ImMessageCenterPojo bmd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bmb = cVar;
        this.bmd = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bmd.getLast_content_time() < next.getLast_content_time()) {
                    this.bmd.setLast_content(next.getLast_content());
                    this.bmd.setLast_content_time(next.getLast_content_time());
                    this.bmd.setLast_rid(next.getLast_rid());
                    this.bmd.setLast_user_name(next.getLast_user_name());
                }
                this.bmd.setUnread_count(next.getUnread_count() + this.bmd.getUnread_count());
                this.bmd.setIs_hidden(0);
            }
        }
    }
}
