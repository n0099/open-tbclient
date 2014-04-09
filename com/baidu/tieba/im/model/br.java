package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class br extends com.baidu.adp.framework.c.a {
    final /* synthetic */ SnapGroupMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(SnapGroupMsglistModel snapGroupMsglistModel, int i) {
        super(0);
        this.a = snapGroupMsglistModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || customResponsedMessage2.g() != 2013002) {
            return;
        }
        this.a.a((com.baidu.adp.framework.message.f<?>) customResponsedMessage2);
    }
}
