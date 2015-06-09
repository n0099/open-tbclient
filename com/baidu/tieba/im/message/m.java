package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage bnB;
    private final /* synthetic */ ImMessageCenterPojo bnC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bnB = responsePullMessage;
        this.bnC = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.Rw().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.bnC != null) {
                this.bnC.setGid(String.valueOf("-1001"));
                this.bnC.setCustomGroupType(-7);
                if (i == 0) {
                    this.bnC.setUnread_count(0);
                } else if (i == 1) {
                    this.bnC.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.bnC.setIs_hidden(0);
                }
                com.baidu.tieba.im.db.k.Rw().a(this.bnC, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.n.RC().a(com.baidu.adp.lib.g.c.c(str, 0L), list, true);
    }
}
