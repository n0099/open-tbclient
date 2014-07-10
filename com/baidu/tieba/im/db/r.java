package com.baidu.tieba.im.db;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ q b;
    private final /* synthetic */ CustomResponsedMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, CustomResponsedMessage customResponsedMessage) {
        this.b = qVar;
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
