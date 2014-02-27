package com.baidu.tieba.im.groupUpdates;

import java.util.List;
/* loaded from: classes.dex */
final class o extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ m a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(m mVar) {
        this.a = mVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        List<UpdatesItemData> list;
        com.baidu.tieba.im.db.c a = com.baidu.tieba.im.db.c.a();
        list = this.a.a;
        return Boolean.valueOf(a.a(list));
    }
}
