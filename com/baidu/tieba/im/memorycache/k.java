package com.baidu.tieba.im.memorycache;

import android.util.SparseArray;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0059a {
    final /* synthetic */ b cmP;
    private final /* synthetic */ SparseArray cmU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar, SparseArray sparseArray) {
        this.cmP = bVar;
        this.cmU = sparseArray;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        boolean l;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            l = this.cmP.l(next);
            if (l) {
                this.cmU.put(com.baidu.adp.lib.h.b.g(next.getGid(), 0), Long.valueOf(com.baidu.tieba.im.util.g.bl(next.getPulled_msgId())));
            }
        }
    }
}
