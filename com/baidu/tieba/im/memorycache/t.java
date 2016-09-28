package com.baidu.tieba.im.memorycache;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.memorycache.a;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements a.InterfaceC0068a {
    final /* synthetic */ b dig;
    private final /* synthetic */ List dih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(b bVar, List list) {
        this.dig = bVar;
        this.dih = list;
    }

    @Override // com.baidu.tieba.im.memorycache.a.InterfaceC0068a
    public void a(Iterator<ImMessageCenterPojo> it) {
        while (it.hasNext()) {
            this.dih.add(it.next());
        }
    }
}
