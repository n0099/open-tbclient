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
    final /* synthetic */ ResponsePullMessage bFk;
    private final /* synthetic */ ImMessageCenterPojo bFl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bFk = responsePullMessage;
        this.bFl = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.TK().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.bFl != null) {
                this.bFl.setGid(String.valueOf("-1001"));
                this.bFl.setCustomGroupType(-7);
                if (i == 0) {
                    this.bFl.setUnread_count(0);
                } else if (i == 1) {
                    this.bFl.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.bFl.setIs_hidden(0);
                }
                i.TK().a(this.bFl, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void e(String str, List<CommonMsgPojo> list) {
        l.TQ().a(b.c(str, 0L), list, true);
    }
}
