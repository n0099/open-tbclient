package com.baidu.tieba.im.db;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tieba.im.b.d {
    final /* synthetic */ i a;
    private final /* synthetic */ Set b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(i iVar, Set set) {
        this.a = iVar;
        this.b = set;
    }

    @Override // com.baidu.tieba.im.b.d
    public void a(ImMessageCenterPojo imMessageCenterPojo) {
        this.b.add(imMessageCenterPojo.getGid());
    }
}
