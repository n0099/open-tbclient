package com.baidu.tieba.im.memorycache;

import android.util.SparseArray;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements b {
    final /* synthetic */ c bgA;
    private final /* synthetic */ SparseArray bgF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar, SparseArray sparseArray) {
        this.bgA = cVar;
        this.bgF = sparseArray;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        boolean q;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            q = this.bgA.q(next);
            if (q) {
                this.bgF.put(com.baidu.adp.lib.g.c.toInt(next.getGid(), 0), Long.valueOf(com.baidu.tieba.im.util.h.ag(next.getPulled_msgId())));
            }
        }
    }
}
