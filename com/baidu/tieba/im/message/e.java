package com.baidu.tieba.im.message;

import com.baidu.adp.lib.h.b;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ ResponsePullMessage bUM;
    private final /* synthetic */ ImMessageCenterPojo bUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bUM = responsePullMessage;
        this.bUO = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.Xl().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.bUO != null) {
                if (userType == 1 || userType == 3) {
                    this.bUO.setGid(String.valueOf("-1000"));
                    this.bUO.setCustomGroupType(-8);
                    if (i == 0) {
                        this.bUO.setUnread_count(0);
                    } else if (i == 1) {
                        this.bUO.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.bUO.setIs_hidden(0);
                    }
                    i.Xl().a(this.bUO, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void f(String str, List<CommonMsgPojo> list) {
        k.Xq().a(b.c(str, 0L), list, true);
    }
}
