package com.baidu.tieba.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class ay extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ ax a;
    private final /* synthetic */ List b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar, List list) {
        this.a = axVar;
        this.b = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (this.b != null && this.b.size() > 0) {
            com.baidu.tieba.im.db.m.a().a(this.b);
            return null;
        }
        return null;
    }
}
