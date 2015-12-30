package com.baidu.tieba.im.memorycache;

import android.util.SparseArray;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0062a {
    final /* synthetic */ b bWT;
    private final /* synthetic */ SparseArray bWY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar, SparseArray sparseArray) {
        this.bWT = bVar;
        this.bWY = sparseArray;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0062a
    public void a(Iterator<ImMessageCenterPojo> it) {
        boolean l;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            l = this.bWT.l(next);
            if (l) {
                this.bWY.put(com.baidu.adp.lib.h.b.g(next.getGid(), 0), Long.valueOf(com.baidu.tieba.im.util.g.bd(next.getPulled_msgId())));
            }
        }
    }
}
