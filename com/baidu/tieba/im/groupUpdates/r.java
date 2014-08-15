package com.baidu.tieba.im.groupUpdates;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ p a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar) {
        this.a = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        List<UpdatesItemData> list;
        com.baidu.tieba.im.db.d a = com.baidu.tieba.im.db.d.a();
        list = this.a.a;
        return Boolean.valueOf(a.a(list));
    }
}
