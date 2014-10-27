package com.baidu.tieba.im.memorycache;

import android.util.SparseArray;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements b {
    final /* synthetic */ c bcU;
    private final /* synthetic */ SparseArray bcZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar, SparseArray sparseArray) {
        this.bcU = cVar;
        this.bcZ = sparseArray;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        boolean j;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            j = this.bcU.j(next);
            if (j) {
                this.bcZ.put(com.baidu.adp.lib.g.c.f(next.getGid(), 0), Long.valueOf(com.baidu.tieba.im.chat.bu.G(next.getPulled_msgId())));
            }
        }
    }
}
