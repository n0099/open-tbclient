package com.baidu.tieba.im.memorycache;

import android.util.SparseArray;
import com.baidu.tieba.im.chat.bu;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements b {
    final /* synthetic */ c a;
    private final /* synthetic */ SparseArray b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(c cVar, SparseArray sparseArray) {
        this.a = cVar;
        this.b = sparseArray;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        boolean h;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            h = this.a.h(next);
            if (h) {
                this.b.put(com.baidu.adp.lib.e.b.a(next.getGid(), 0), Long.valueOf(bu.c(next.getPulled_msgId())));
            }
        }
    }
}
