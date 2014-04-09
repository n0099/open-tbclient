package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class al extends com.baidu.adp.framework.c.a {
    final /* synthetic */ MsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(MsglistModel msglistModel, int i) {
        super(0);
        this.a = msglistModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.adp.a.h hVar;
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2.g() == 2001113) {
            this.a.i();
        } else if (customResponsedMessage2.g() == 501126) {
            com.baidu.adp.lib.util.f.e("simon", "onMessage", "msg = " + customResponsedMessage2);
            if (customResponsedMessage2 instanceof com.baidu.adp.framework.message.f) {
                this.a.b.getChatMessages().add((com.baidu.tieba.im.message.a.a) customResponsedMessage2.h());
                hVar = this.a.mLoadDataCallBack;
                hVar.a(this.a.b);
            }
        }
    }
}
