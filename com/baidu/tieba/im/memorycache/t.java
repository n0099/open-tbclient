package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.InterfaceC0064a {
    final /* synthetic */ b cbn;
    private final /* synthetic */ List cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(b bVar, List list) {
        this.cbn = bVar;
        this.cbo = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0064a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.cbo.add(it.next());
        }
    }
}
