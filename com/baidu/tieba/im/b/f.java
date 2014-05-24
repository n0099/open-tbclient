package com.baidu.tieba.im.b;

import com.baidu.tieba.im.chat.bv;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d {
    @Override // com.baidu.tieba.im.b.d
    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        int a = com.baidu.adp.lib.f.b.a(imMessageCenterPojo.getGid(), 0);
        if (a != 0 && imMessageCenterPojo.getIs_delete() == 0) {
            com.baidu.tbadk.coreExtra.messageCenter.e.a().a(a, bv.c(imMessageCenterPojo.getPulled_msgId()));
        }
    }
}
