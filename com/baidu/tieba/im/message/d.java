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
    final /* synthetic */ ResponsePullMessage cTJ;
    private final /* synthetic */ ImMessageCenterPojo cTK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.cTJ = responsePullMessage;
        this.cTK = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.amO().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.cTK != null) {
                this.cTK.setGid(String.valueOf("-1001"));
                this.cTK.setCustomGroupType(-7);
                if (i == 0) {
                    this.cTK.setUnread_count(0);
                } else if (i == 1) {
                    this.cTK.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.cTK.setIs_hidden(0);
                }
                i.amO().a(this.cTK, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void f(String str, List<CommonMsgPojo> list) {
        l.amU().a(b.c(str, 0L), list, true);
    }
}
