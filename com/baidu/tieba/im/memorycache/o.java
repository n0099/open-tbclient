package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements b {
    final /* synthetic */ c bma;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(c cVar) {
        this.bma = cVar;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            next.setIs_hidden(1);
            next.setLast_content("");
            next.setLast_content_time(0L);
            next.setLast_user_name("");
            next.setUnread_count(0);
            next.setSend_status(0);
        }
    }
}
