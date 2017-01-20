package com.baidu.tieba.im.message;

import com.baidu.adp.lib.g.b;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class d implements a.b {
    private final /* synthetic */ ImMessageCenterPojo dbA;
    final /* synthetic */ ResponsePullMessage dbz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.dbz = responsePullMessage;
        this.dbA = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.aqq().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.dbA != null) {
                this.dbA.setGid(String.valueOf("-1001"));
                this.dbA.setCustomGroupType(-7);
                if (i == 0) {
                    this.dbA.setUnread_count(0);
                } else if (i == 1) {
                    this.dbA.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.dbA.setIs_hidden(0);
                }
                i.aqq().a(this.dbA, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void e(String str, List<CommonMsgPojo> list) {
        l.aqw().a(b.c(str, 0L), list, true);
    }
}
