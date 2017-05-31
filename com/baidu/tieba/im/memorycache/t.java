package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.InterfaceC0067a {
    final /* synthetic */ b dcA;
    private final /* synthetic */ List dcB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(b bVar, List list) {
        this.dcA = bVar;
        this.dcB = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0067a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.dcB.add(it.next());
        }
    }
}
