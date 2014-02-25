package com.baidu.tieba.im.groupUpdates;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.a = mVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        List<UpdatesItemData> list;
        com.baidu.tieba.im.db.c a = com.baidu.tieba.im.db.c.a();
        list = this.a.a;
        return Boolean.valueOf(a.a(list));
    }
}
