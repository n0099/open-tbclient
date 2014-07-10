package com.baidu.tieba.im.c;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.y;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.b.d {
    final /* synthetic */ b a;
    private final /* synthetic */ LinkedList b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(b bVar, LinkedList linkedList, LinkedList linkedList2) {
        this.a = bVar;
        this.b = linkedList;
        this.c = linkedList2;
    }

    @Override // com.baidu.tieba.im.b.d
    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        boolean z;
        if (imMessageCenterPojo != null && imMessageCenterPojo.getCustomGroupType() != 3 && imMessageCenterPojo.getCustomGroupType() != 2 && imMessageCenterPojo.getCustomGroupType() != 4) {
            Iterator it = this.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                String str = (String) it.next();
                if (imMessageCenterPojo.getGid() != null && imMessageCenterPojo.getGid().equals(str)) {
                    y.a().c(TbadkApplication.getCurrentAccount(), str, true);
                    z = false;
                    break;
                }
            }
            if (z) {
                y.a().c(TbadkApplication.getCurrentAccount(), imMessageCenterPojo.getGid(), false);
                imMessageCenterPojo.setIs_delete(1);
                this.c.add(imMessageCenterPojo);
            }
        }
    }
}
