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
    final /* synthetic */ ResponsePullMessage dpv;
    private final /* synthetic */ ImMessageCenterPojo dpw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.dpv = responsePullMessage;
        this.dpw = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.auK().a(imMessageCenterPojo, 2);
            if (imMessageCenterPojo.getIsFriend() == 0 && this.dpw != null) {
                this.dpw.setGid(String.valueOf("-1001"));
                this.dpw.setCustomGroupType(-7);
                if (i == 0) {
                    this.dpw.setUnread_count(0);
                } else if (i == 1) {
                    this.dpw.setUnread_count(1);
                } else {
                    i2 = 1;
                }
                if (z) {
                    this.dpw.setIs_hidden(0);
                }
                i.auK().a(this.dpw, i2);
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void f(String str, List<CommonMsgPojo> list) {
        l.auQ().a(b.c(str, 0L), list, true);
    }
}
