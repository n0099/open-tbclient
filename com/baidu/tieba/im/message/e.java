package com.baidu.tieba.im.message;

import com.baidu.adp.lib.g.b;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.i;
import com.baidu.tieba.im.db.k;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.List;
/* loaded from: classes.dex */
class e implements a.b {
    final /* synthetic */ ResponsePullMessage bFF;
    private final /* synthetic */ ImMessageCenterPojo bFH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ResponsePullMessage responsePullMessage, ImMessageCenterPojo imMessageCenterPojo) {
        this.bFF = responsePullMessage;
        this.bFH = imMessageCenterPojo;
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void a(ImMessageCenterPojo imMessageCenterPojo, int i, boolean z) {
        int i2 = 2;
        if (imMessageCenterPojo != null) {
            i.Uf().a(imMessageCenterPojo, 2);
            int userType = imMessageCenterPojo.getUserType();
            if (this.bFH != null) {
                if (userType == 1 || userType == 3) {
                    this.bFH.setGid(String.valueOf("-1000"));
                    this.bFH.setCustomGroupType(-8);
                    if (i == 0) {
                        this.bFH.setUnread_count(0);
                    } else if (i == 1) {
                        this.bFH.setUnread_count(1);
                    } else {
                        i2 = 1;
                    }
                    if (z) {
                        this.bFH.setIs_hidden(0);
                    }
                    i.Uf().a(this.bFH, i2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.b
    public void e(String str, List<CommonMsgPojo> list) {
        k.Uk().a(b.c(str, 0L), list, true);
    }
}
