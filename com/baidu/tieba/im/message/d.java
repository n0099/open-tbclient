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
    final /* synthetic */ ResponsePullMessage bEZ;
    private final /* synthetic */ ImMessageCenterPojo bFa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bEZ = responsePullMessage;
        this.bFa = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.TO().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.bFa != null) {
                this.bFa.setGid(String.valueOf("-1001"));
                this.bFa.setCustomGroupType(-7);
                if (i == 0) {
                    this.bFa.setUnread_count(0);
                } else if (i == 1) {
                    this.bFa.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.bFa.setIs_hidden(0);
                }
                i.TO().a(this.bFa, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void e(String str, List<CommonMsgPojo> list) {
        l.TU().a(b.c(str, 0L), list, true);
    }
}
