package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements a.InterfaceC0065a {
    final /* synthetic */ b dgJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(b bVar) {
        this.dgJ = bVar;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0065a
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
