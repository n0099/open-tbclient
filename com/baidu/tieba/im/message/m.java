package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage bkV;
    private final /* synthetic */ ImMessageCenterPojo bkW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bkV = responsePullMessage;
        this.bkW = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.Qg().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.bkW != null) {
                this.bkW.setGid(String.valueOf("-1001"));
                this.bkW.setCustomGroupType(-7);
                if (i == 0) {
                    this.bkW.setUnread_count(0);
                } else if (i == 1) {
                    this.bkW.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.bkW.setIs_hidden(0);
                }
                com.baidu.tieba.im.db.k.Qg().a(this.bkW, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.n.Qm().a(com.baidu.adp.lib.g.c.a(str, 0L), list, true);
    }
}
