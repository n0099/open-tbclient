package com.baidu.tieba.im.memorycache;

import android.util.SparseArray;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0070a {
    private final /* synthetic */ SparseArray dkC;
    final /* synthetic */ b dkx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar, SparseArray sparseArray) {
        this.dkx = bVar;
        this.dkC = sparseArray;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0070a
    public void a(Iterator<ImMessageCenterPojo> it) {
        boolean l;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            l = this.dkx.l(next);
            if (l) {
                this.dkC.put(com.baidu.adp.lib.g.b.g(next.getGid(), 0), Long.valueOf(com.baidu.tieba.im.util.g.bP(next.getPulled_msgId())));
            }
        }
    }
}
