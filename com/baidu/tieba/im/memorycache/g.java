package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements a.InterfaceC0067a {
    final /* synthetic */ b dcA;
    private final /* synthetic */ ImMessageCenterPojo dcC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, ImMessageCenterPojo imMessageCenterPojo) {
        this.dcA = bVar;
        this.dcC = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0067a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getCustomGroupType() == 2 && next.getIsFriend() == 0 && next.getIs_hidden() == 0) {
                if (this.dcC.getLast_content_time() < next.getLast_content_time()) {
                    this.dcC.setLast_content(next.getLast_content());
                    this.dcC.setLast_content_time(next.getLast_content_time());
                    this.dcC.setLast_rid(next.getLast_rid());
                    this.dcC.setLast_user_name(next.getLast_user_name());
                    this.dcC.setSend_status(next.getSend_status());
                }
                this.dcC.setUnread_count(next.getUnread_count() + this.dcC.getUnread_count());
                this.dcC.setIs_hidden(0);
            }
        }
    }
}
