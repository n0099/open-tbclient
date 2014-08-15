package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
class q extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ p a;
    private final /* synthetic */ CustomResponsedMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, CustomResponsedMessage customResponsedMessage) {
        this.a = pVar;
        this.b = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (this.b.getData() instanceof String) {
            f.a((String) this.b.getData());
            return null;
        }
        return null;
    }
}
