package com.baidu.tieba.im.pushNotify;

import com.baidu.tieba.im.data.ImMessageCenterShowItemData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.im.b.d {
    final /* synthetic */ a a;
    private final /* synthetic */ com.baidu.tbadk.coreExtra.b.c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, com.baidu.tbadk.coreExtra.b.c cVar) {
        this.a = aVar;
        this.b = cVar;
    }

    @Override // com.baidu.tieba.im.b.d
    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        boolean a;
        ImMessageCenterShowItemData a2;
        a = this.a.a(imMessageCenterPojo);
        if (a) {
            if (imMessageCenterPojo.getCustomGroupType() != 4) {
                if (imMessageCenterPojo.getCustomGroupType() != 2 || imMessageCenterPojo.getIsFriend() != 0) {
                    a2 = this.a.a(imMessageCenterPojo.getGid(), imMessageCenterPojo);
                    this.a.a(a2, this.b);
                    return;
                }
                this.a.c(imMessageCenterPojo.getGid(), imMessageCenterPojo);
                return;
            }
            this.a.b(imMessageCenterPojo.getGid(), imMessageCenterPojo);
        }
    }
}
