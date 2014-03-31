package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
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
        if (customResponsedMessage instanceof ResponseUnLoginMessage) {
            this.a.mLoadDataMode = 11;
            hVar = this.a.mLoadDataCallBack;
            hVar.a(null);
        }
    }
}
