package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class k implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage bia;
    private final /* synthetic */ ImMessageCenterPojo bib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bia = responsePullMessage;
        this.bib = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.MD().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.bib != null) {
                this.bib.setGid(String.valueOf("-1001"));
                this.bib.setCustomGroupType(-7);
                if (i == 0) {
                    this.bib.setUnread_count(0);
                } else if (i == 1) {
                    this.bib.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.bib.setIs_hidden(0);
                }
                com.baidu.tieba.im.db.k.MD().a(this.bib, i2);
            }
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            imMessageCenterPojo2.setGid(String.valueOf(com.baidu.tieba.im.c.a.bnb));
            imMessageCenterPojo2.setCustomGroupType(-1);
            imMessageCenterPojo2.setIs_hidden(1);
            imMessageCenterPojo2.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            com.baidu.tieba.im.db.k.MD().a(imMessageCenterPojo2);
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.o.MO().a(com.baidu.adp.lib.g.c.a(str, 0L), list, true);
    }
}
