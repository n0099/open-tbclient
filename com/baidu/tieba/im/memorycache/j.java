package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements b {
    final /* synthetic */ c a;
    private final /* synthetic */ ImMessageCenterPojo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(c cVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.a = cVar;
        this.b = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4) {
                if (this.b.getLast_content_time() < next.getLast_content_time()) {
                    this.b.setLast_content(next.getLast_content());
                    this.b.setLast_content_time(next.getLast_content_time());
                    this.b.setLast_rid(next.getLast_rid());
                    this.b.setLast_user_name(next.getLast_user_name());
                }
                if (next.getIs_hidden() == 0) {
                    this.b.setIs_hidden(0);
                    this.b.setUnread_count(next.getUnread_count() + this.b.getUnread_count());
                }
            }
        }
    }
}
