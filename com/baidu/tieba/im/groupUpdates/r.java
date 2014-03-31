package com.baidu.tieba.im.groupUpdates;

import java.util.List;
/* loaded from: classes.dex */
final class r extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.b = pVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        List<UpdatesItemData> list;
        com.baidu.tieba.im.db.d a = com.baidu.tieba.im.db.d.a();
        list = this.b.a;
        return Boolean.valueOf(a.a(list));
    }
}
