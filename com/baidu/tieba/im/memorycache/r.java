package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements b {
    final /* synthetic */ c bhR;
    private final /* synthetic */ List bhS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(c cVar, List list) {
        this.bhR = cVar;
        this.bhS = list;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.bhS.add(it.next());
        }
    }
}
