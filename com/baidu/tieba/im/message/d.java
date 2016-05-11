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
    final /* synthetic */ ResponsePullMessage cou;
    private final /* synthetic */ ImMessageCenterPojo cov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.cou = responsePullMessage;
        this.cov = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.aex().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.cov != null) {
                this.cov.setGid(String.valueOf("-1001"));
                this.cov.setCustomGroupType(-7);
                if (i == 0) {
                    this.cov.setUnread_count(0);
                } else if (i == 1) {
                    this.cov.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.cov.setIs_hidden(0);
                }
                i.aex().a(this.cov, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void e(String str, List<CommonMsgPojo> list) {
        l.aeD().a(b.c(str, 0L), list, true);
    }
}
