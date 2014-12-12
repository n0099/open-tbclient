package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements b {
    final /* synthetic */ c bgA;
    private final /* synthetic */ ImMessageCenterPojo bgE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.bgA = cVar;
        this.bgE = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.bgE.getLast_content_time() < next.getLast_content_time()) {
                    this.bgE.setLast_content(next.getLast_content());
                    this.bgE.setLast_content_time(next.getLast_content_time());
                    this.bgE.setLast_rid(next.getLast_rid());
                    this.bgE.setLast_user_name(next.getLast_user_name());
                }
                this.bgE.setIs_hidden(0);
                this.bgE.setUnread_count(next.getUnread_count() + this.bgE.getUnread_count());
            }
        }
    }
}
