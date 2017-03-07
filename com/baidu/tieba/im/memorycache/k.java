package com.baidu.tieba.im.memorycache;

import android.util.SparseArray;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0065a {
    final /* synthetic */ b dcl;
    private final /* synthetic */ SparseArray dcq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar, SparseArray sparseArray) {
        this.dcl = bVar;
        this.dcq = sparseArray;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0065a
    public void a(Iterator<ImMessageCenterPojo> it) {
        boolean l;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            l = this.dcl.l(next);
            if (l) {
                this.dcq.put(com.baidu.adp.lib.g.b.g(next.getGid(), 0), Long.valueOf(com.baidu.tieba.im.util.g.bN(next.getPulled_msgId())));
            }
        }
    }
}
