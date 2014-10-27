package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements b {
    final /* synthetic */ c bcU;
    private final /* synthetic */ ImMessageCenterPojo bcW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bcU = cVar;
        this.bcW = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.bcW.getLast_content_time() < next.getLast_content_time()) {
                    this.bcW.setLast_content(next.getLast_content());
                    this.bcW.setLast_content_time(next.getLast_content_time());
                    this.bcW.setLast_rid(next.getLast_rid());
                    this.bcW.setLast_user_name(next.getLast_user_name());
                }
                this.bcW.setUnread_count(next.getUnread_count() + this.bcW.getUnread_count());
                this.bcW.setIs_hidden(0);
            }
        }
    }
}
