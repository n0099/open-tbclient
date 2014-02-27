package com.baidu.tieba.im.b;

import com.baidu.tieba.im.data.GroupMidData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class d implements com.baidu.tieba.im.db.e {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.baidu.tieba.im.db.e
    public final void a(Iterator<ImMessageCenterPojo> it) {
        LinkedList linkedList;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next.getIs_delete() == 0) {
                long pulled_msgId = next.getPulled_msgId() / 100;
                if (pulled_msgId != 0) {
                    GroupMidData groupMidData = new GroupMidData();
                    groupMidData.setGroupId(Integer.parseInt(next.getGid()));
                    groupMidData.setLastMsgId(pulled_msgId);
                    linkedList = this.a.a.h;
                    linkedList.add(groupMidData);
                }
            }
        }
    }
}
