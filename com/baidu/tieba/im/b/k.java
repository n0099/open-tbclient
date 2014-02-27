package com.baidu.tieba.im.b;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.groupInfo.v;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
final class k implements com.baidu.tieba.im.db.e {
    final /* synthetic */ i a;
    private final /* synthetic */ LinkedList b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, LinkedList linkedList, LinkedList linkedList2) {
        this.a = iVar;
        this.b = linkedList;
        this.c = linkedList2;
    }

    @Override // com.baidu.tieba.im.db.e
    public final void a(Iterator<ImMessageCenterPojo> it) {
        boolean z;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (next != null) {
                if (next.getGroup_type() != 7) {
                    Iterator it2 = this.b.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            z = true;
                            break;
                        }
                        String str = (String) it2.next();
                        if (next.getGid() != null && next.getGid().equals(str)) {
                            v.d(TiebaApplication.v(), str, true);
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        v.d(TiebaApplication.v(), next.getGid(), false);
                        next.setIs_delete(1);
                        this.c.add(next);
                    }
                } else {
                    return;
                }
            }
        }
    }
}
