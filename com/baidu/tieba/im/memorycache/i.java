package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.InterfaceC0068a {
    final /* synthetic */ b cXb;
    private final /* synthetic */ ImMessageCenterPojo cXf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.cXb = bVar;
        this.cXf = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0068a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 4 && next.getIs_hidden() == 0 && (next.getUserType() == 1 || next.getUserType() == 3)) {
                if (this.cXf.getLast_content_time() < next.getLast_content_time()) {
                    this.cXf.setLast_content(next.getLast_content());
                    this.cXf.setLast_content_time(next.getLast_content_time());
                    this.cXf.setLast_rid(next.getLast_rid());
                    this.cXf.setLast_user_name(next.getLast_user_name());
                }
                this.cXf.setIs_hidden(0);
                this.cXf.setUnread_count(next.getUnread_count() + this.cXf.getUnread_count());
            }
        }
    }
}
