package com.baidu.tieba.im.message;

import com.baidu.adp.lib.h.b;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ ResponsePullMessage ccS;
    private final /* synthetic */ ImMessageCenterPojo ccT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.ccS = responsePullMessage;
        this.ccT = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.abc().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.ccT != null) {
                this.ccT.setGid(String.valueOf("-1001"));
                this.ccT.setCustomGroupType(-7);
                if (i == 0) {
                    this.ccT.setUnread_count(0);
                } else if (i == 1) {
                    this.ccT.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.ccT.setIs_hidden(0);
                }
                i.abc().a(this.ccT, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void f(String str, List<CommonMsgPojo> list) {
        l.abi().a(b.c(str, 0L), list, true);
    }
}
