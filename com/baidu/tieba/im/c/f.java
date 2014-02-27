package com.baidu.tieba.im.c;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.mention.ah;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements com.baidu.tieba.im.db.e {
    final /* synthetic */ a a;
    private final /* synthetic */ ah b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar, ah ahVar) {
        this.a = aVar;
        this.b = ahVar;
    }

    @Override // com.baidu.tieba.im.db.e
    public final void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            ImMessageCenterPojo next = it.next();
            if (a.a(this.a, next)) {
                a.a(this.a, a.a(this.a, next.getGid(), next), this.b);
            }
        }
    }
}
