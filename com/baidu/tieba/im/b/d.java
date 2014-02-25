package com.baidu.tieba.im.b;

import com.baidu.tieba.im.chat.be;
import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.tieba.im.db.e {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.tieba.im.db.e
    public void a(Iterator<ImMessageCenterPojo> it) {
        a aVar;
        LinkedList linkedList;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getIs_delete() == 0) {
                long c = be.c(next.getPulled_msgId());
                if (c != 0) {
                    GroupMidData groupMidData = new GroupMidData();
                    groupMidData.setGroupId(Integer.parseInt(next.getGid()));
                    groupMidData.setLastMsgId(c);
                    aVar = this.a.a;
                    linkedList = aVar.h;
                    linkedList.add(groupMidData);
                }
            }
        }
    }
}
