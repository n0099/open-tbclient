package com.baidu.tieba.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class ar extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ aq b;
    private final /* synthetic */ List c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(aq aqVar, List list) {
        this.b = aqVar;
        this.c = list;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (this.c != null && this.c.size() > 0) {
            com.baidu.tieba.im.db.n.a().a(this.c);
            return null;
        }
        return null;
    }
}
