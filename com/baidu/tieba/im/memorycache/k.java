package com.baidu.tieba.im.memorycache;

import android.util.SparseArray;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements a.InterfaceC0059a {
    final /* synthetic */ b bzO;
    private final /* synthetic */ SparseArray bzT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(b bVar, SparseArray sparseArray) {
        this.bzO = bVar;
        this.bzT = sparseArray;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0059a
    public void a(Iterator<ImMessageCenterPojo> it) {
        boolean j;
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            j = this.bzO.j(next);
            if (j) {
                this.bzT.put(com.baidu.adp.lib.g.b.g(next.getGid(), 0), Long.valueOf(com.baidu.tieba.im.util.g.aq(next.getPulled_msgId())));
            }
        }
    }
}
