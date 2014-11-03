package com.baidu.tieba.im.message;

import com.baidu.tieba.im.chat.w;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class l implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage beH;
    private final /* synthetic */ ImMessageCenterPojo beJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.beH = responsePullMessage;
        this.beJ = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.MJ().a(imMessageCenterPojo, 2);
            if (this.beJ != null) {
                this.beJ.setGid(String.valueOf("-1000"));
                this.beJ.setCustomGroupType(-8);
                if (i == 0) {
                    this.beJ.setUnread_count(0);
                } else if (i == 1) {
                    this.beJ.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.beJ.setIs_hidden(0);
                }
                com.baidu.tieba.im.db.k.MJ().a(this.beJ, i2);
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
        com.baidu.tieba.im.db.n.MT().a(com.baidu.adp.lib.g.c.a(str, 0L), list, true);
    }
}
