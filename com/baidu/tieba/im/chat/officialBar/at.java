package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class at extends com.baidu.adp.framework.c.a {
    final /* synthetic */ OfficialBarTipActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public at(OfficialBarTipActivity officialBarTipActivity, int i) {
        super(0);
        this.a = officialBarTipActivity;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.model.bd bdVar;
        com.baidu.tieba.im.a<Void> aVar;
        bdVar = this.a.a;
        aVar = this.a.d;
        bdVar.a(aVar);
    }
}
