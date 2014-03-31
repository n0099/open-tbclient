package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements com.baidu.tieba.im.b.d {
    final /* synthetic */ h a;
    private final /* synthetic */ Set b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(h hVar, Set set) {
        this.a = hVar;
        this.b = set;
    }

    @Override // com.baidu.tieba.im.b.d
    public final void a(ImMessageCenterPojo imMessageCenterPojo) {
        this.b.add(imMessageCenterPojo.getGid());
    }
}
