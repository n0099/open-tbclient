package com.baidu.tieba.im.memorycache;

import android.util.SparseArray;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0065a {
    final /* synthetic */ b clR;
    private final /* synthetic */ SparseArray clW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar, SparseArray sparseArray) {
        this.clR = bVar;
        this.clW = sparseArray;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0065a
    public void a(Iterator<ImMessageCenterPojo> it) {
        boolean l;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            l = this.clR.l(next);
            if (l) {
                this.clW.put(com.baidu.adp.lib.h.b.g(next.getGid(), 0), Long.valueOf(com.baidu.tieba.im.util.g.bl(next.getPulled_msgId())));
            }
        }
    }
}
