package com.baidu.tieba.im.memorycache;

import android.util.SparseArray;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements b {
    final /* synthetic */ c bhS;
    private final /* synthetic */ SparseArray bhX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar, SparseArray sparseArray) {
        this.bhS = cVar;
        this.bhX = sparseArray;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        boolean q;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            q = this.bhS.q(next);
            if (q) {
                this.bhX.put(com.baidu.adp.lib.g.c.toInt(next.getGid(), 0), Long.valueOf(com.baidu.tieba.im.util.h.ag(next.getPulled_msgId())));
            }
        }
    }
}
