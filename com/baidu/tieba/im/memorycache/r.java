package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.InterfaceC0068a {
    final /* synthetic */ b cXb;
    private final /* synthetic */ List cXc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(b bVar, List list) {
        this.cXb = bVar;
        this.cXc = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0068a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.cXc.add(it.next());
        }
    }
}
