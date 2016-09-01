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
    final /* synthetic */ ResponsePullMessage dio;
    private final /* synthetic */ ImMessageCenterPojo dip;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.dio = responsePullMessage;
        this.dip = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.aso().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.dip != null) {
                this.dip.setGid(String.valueOf("-1001"));
                this.dip.setCustomGroupType(-7);
                if (i == 0) {
                    this.dip.setUnread_count(0);
                } else if (i == 1) {
                    this.dip.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.dip.setIs_hidden(0);
                }
                i.aso().a(this.dip, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void f(String str, List<CommonMsgPojo> list) {
        l.asu().a(b.c(str, 0L), list, true);
    }
}
