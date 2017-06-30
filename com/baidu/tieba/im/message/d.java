package com.baidu.tieba.im.message;

import com.baidu.adp.lib.g.b;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.j;
import com.baidu.tieba.im.db.m;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class d implements a.b {
    final /* synthetic */ ResponsePullMessage dmc;
    private final /* synthetic */ ImMessageCenterPojo dmd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.dmc = responsePullMessage;
        this.dmd = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            j.asi().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.dmd != null) {
                this.dmd.setGid(String.valueOf("-1001"));
                this.dmd.setCustomGroupType(-7);
                if (i == 0) {
                    this.dmd.setUnread_count(0);
                } else if (i == 1) {
                    this.dmd.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.dmd.setIs_hidden(0);
                }
                j.asi().a(this.dmd, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void h(String str, List<CommonMsgPojo> list) {
        m.aso().a(b.c(str, 0L), list, true);
    }
}
