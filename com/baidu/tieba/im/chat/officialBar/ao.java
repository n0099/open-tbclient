package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class ao extends com.baidu.adp.framework.c.a {
    final /* synthetic */ OfficialBarInfoActivity a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null || customResponsedMessage2.g() != 2001155) {
            return;
        }
        this.a.showToast(com.baidu.tieba.im.j.cash_del_suc);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ao(OfficialBarInfoActivity officialBarInfoActivity) {
        super(2001155);
        this.a = officialBarInfoActivity;
    }
}
