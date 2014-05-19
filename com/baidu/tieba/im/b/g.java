package com.baidu.tieba.im.b;

import com.baidu.tieba.im.chat.bw;
import com.baidu.tieba.im.chat.x;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements d {
    @Override // com.baidu.tieba.im.b.d
    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (x.a != 0) {
            com.baidu.tbadk.coreExtra.messageCenter.e.a().a(x.a, bw.c(imMessageCenterPojo.getPulled_msgId()));
        }
    }
}
