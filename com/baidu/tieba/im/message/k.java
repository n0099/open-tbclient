package com.baidu.tieba.im.message;

import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class k implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage beH;
    private final /* synthetic */ ImMessageCenterPojo beI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.beH = responsePullMessage;
        this.beI = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.MJ().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.beI != null) {
                this.beI.setGid(String.valueOf("-1001"));
                this.beI.setCustomGroupType(-7);
                if (i == 0) {
                    this.beI.setUnread_count(0);
                } else if (i == 1) {
                    this.beI.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.beI.setIs_hidden(0);
                }
                com.baidu.tieba.im.db.k.MJ().a(this.beI, i2);
            }
            ImMessageCenterPojo imMessageCenterPojo2 = new ImMessageCenterPojo();
            imMessageCenterPojo2.setGid(String.valueOf(w.aNT));
            imMessageCenterPojo2.setCustomGroupType(-1);
            imMessageCenterPojo2.setIs_hidden(1);
            imMessageCenterPojo2.setPulled_msgId(imMessageCenterPojo.getPulled_msgId());
            com.baidu.tieba.im.db.k.MJ().a(imMessageCenterPojo2);
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void b(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.o.MU().a(com.baidu.adp.lib.g.c.a(str, 0L), list, true);
    }
}
