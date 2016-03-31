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
    final /* synthetic */ ResponsePullMessage cnx;
    private final /* synthetic */ ImMessageCenterPojo cny;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.cnx = responsePullMessage;
        this.cny = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.aey().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.cny != null) {
                this.cny.setGid(String.valueOf("-1001"));
                this.cny.setCustomGroupType(-7);
                if (i == 0) {
                    this.cny.setUnread_count(0);
                } else if (i == 1) {
                    this.cny.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.cny.setIs_hidden(0);
                }
                i.aey().a(this.cny, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void d(String str, List<CommonMsgPojo> list) {
        l.aeE().a(b.c(str, 0L), list, true);
    }
}
