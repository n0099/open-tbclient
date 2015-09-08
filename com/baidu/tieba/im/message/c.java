package com.baidu.tieba.im.message;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class c implements a.b {
    final /* synthetic */ ResponsePullMessage bBV;
    private final /* synthetic */ ImMessageCenterPojo bBW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bBV = responsePullMessage;
        this.bBW = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.Tg().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.bBW != null) {
                this.bBW.setGid(String.valueOf("-1001"));
                this.bBW.setCustomGroupType(-7);
                if (i == 0) {
                    this.bBW.setUnread_count(0);
                } else if (i == 1) {
                    this.bBW.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.bBW.setIs_hidden(0);
                }
                i.Tg().a(this.bBW, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void e(String str, List<CommonMsgPojo> list) {
        l.Tm().a(com.baidu.adp.lib.g.b.c(str, 0L), list, true);
    }
}
