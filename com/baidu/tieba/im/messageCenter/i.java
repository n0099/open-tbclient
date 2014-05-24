package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.im.chat.w;
/* loaded from: classes.dex */
class i extends com.baidu.tieba.im.b<Integer> {
    final /* synthetic */ h b;
    private final /* synthetic */ boolean c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, boolean z) {
        this.b = hVar;
        this.c = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Integer a() {
        if (!this.c) {
            w.a = com.baidu.tieba.im.db.o.d().a();
            com.baidu.tieba.im.db.b.a().b();
        }
        return 0;
    }
}
