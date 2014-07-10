package com.baidu.tieba.im.chat.notify;
/* loaded from: classes.dex */
class n extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar) {
        this.b = lVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.h.a().b("-1001", true);
        return null;
    }
}
