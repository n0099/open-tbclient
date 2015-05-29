package com.baidu.tieba.im.memorycache;

import android.util.SparseArray;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements b {
    final /* synthetic */ c bma;
    private final /* synthetic */ SparseArray bmf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar, SparseArray sparseArray) {
        this.bma = cVar;
        this.bmf = sparseArray;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        boolean j;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            j = this.bma.j(next);
            if (j) {
                this.bmf.put(com.baidu.adp.lib.g.c.toInt(next.getGid(), 0), Long.valueOf(com.baidu.tieba.im.util.h.ah(next.getPulled_msgId())));
            }
        }
    }
}
