package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.aa;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.im.b.d {
    final /* synthetic */ f a;
    private final /* synthetic */ LinkedList b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, LinkedList linkedList, LinkedList linkedList2) {
        this.a = fVar;
        this.b = linkedList;
        this.c = linkedList2;
    }

    @Override // com.baidu.tieba.im.b.d
    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        boolean z;
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() != 3) {
            Iterator it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                String str = (String) it.next();
                if (imMessageCenterPojo.getGid() != null && imMessageCenterPojo.getGid().equals(str)) {
                    aa.a().c(TbadkApplication.getCurrentAccount(), str, true);
                    z = false;
                    break;
                }
            }
            if (z) {
                aa.a().c(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid(), false);
                imMessageCenterPojo.setIs_delete(1);
                this.c.add(imMessageCenterPojo);
            }
        }
    }
}
