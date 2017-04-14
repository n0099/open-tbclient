package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0064a {
    final /* synthetic */ b daI;
    private final /* synthetic */ ImMessageCenterPojo daK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.daI = bVar;
        this.daK = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.daK.getLast_content_time() < next.getLast_content_time()) {
                    this.daK.setLast_content(next.getLast_content());
                    this.daK.setLast_content_time(next.getLast_content_time());
                    this.daK.setLast_rid(next.getLast_rid());
                    this.daK.setLast_user_name(next.getLast_user_name());
                    this.daK.setSend_status(next.getSend_status());
                }
                this.daK.setUnread_count(next.getUnread_count() + this.daK.getUnread_count());
                this.daK.setIs_hidden(0);
            }
        }
    }
}
