package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements b {
    final /* synthetic */ c bhS;
    private final /* synthetic */ List bhT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(c cVar, List list) {
        this.bhS = cVar;
        this.bhT = list;
    }

    @Override // com.baidu.tieba.im.memorycache.b
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.bhT.add(it.next());
        }
    }
}
