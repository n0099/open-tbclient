package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage bnA;
    private final /* synthetic */ ImMessageCenterPojo bnB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bnA = responsePullMessage;
        this.bnB = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.Rv().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.bnB != null) {
                this.bnB.setGid(String.valueOf("-1001"));
                this.bnB.setCustomGroupType(-7);
                if (i == 0) {
                    this.bnB.setUnread_count(0);
                } else if (i == 1) {
                    this.bnB.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.bnB.setIs_hidden(0);
                }
                com.baidu.tieba.im.db.k.Rv().a(this.bnB, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.n.RB().a(com.baidu.adp.lib.g.c.c(str, 0L), list, true);
    }
}
