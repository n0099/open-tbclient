package com.baidu.tieba.im.memorycache;

import android.util.SparseArray;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0059a {
    final /* synthetic */ b bEd;
    private final /* synthetic */ SparseArray bEi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar, SparseArray sparseArray) {
        this.bEd = bVar;
        this.bEi = sparseArray;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        boolean l;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            l = this.bEd.l(next);
            if (l) {
                this.bEi.put(com.baidu.adp.lib.g.b.g(next.getGid(), 0), Long.valueOf(com.baidu.tieba.im.util.g.aK(next.getPulled_msgId())));
            }
        }
    }
}
