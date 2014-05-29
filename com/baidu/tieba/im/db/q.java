package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ p b;
    private final /* synthetic */ CustomResponsedMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar, CustomResponsedMessage customResponsedMessage) {
        this.b = pVar;
        this.c = customResponsedMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (this.c.getData() instanceof String) {
            g.a((String) this.c.getData());
        }
        com.baidu.tieba.im.b.e.e();
        return null;
    }
}
