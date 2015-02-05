package com.baidu.tieba.im.message;

import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class k implements com.baidu.tieba.im.chat.receiveChatMsgHandler.c {
    final /* synthetic */ ResponsePullMessage bju;
    private final /* synthetic */ ImMessageCenterPojo bjv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bju = responsePullMessage;
        this.bjv = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            com.baidu.tieba.im.db.k.MU().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.bjv != null) {
                this.bjv.setGid(String.valueOf("-1001"));
                this.bjv.setCustomGroupType(-7);
                if (i == 0) {
                    this.bjv.setUnread_count(0);
                } else if (i == 1) {
                    this.bjv.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.bjv.setIs_hidden(0);
                }
                com.baidu.tieba.im.db.k.MU().a(this.bjv, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.c
    public void c(String str, List<CommonMsgPojo> list) {
        com.baidu.tieba.im.db.o.Nf().a(com.baidu.adp.lib.g.c.a(str, 0L), list, true);
    }
}
