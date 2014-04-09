package com.baidu.tieba.im.model;

import com.baidu.adp.framework.message.CustomResponsedMessage;
/* loaded from: classes.dex */
final class bj extends com.baidu.adp.framework.c.a {
    final /* synthetic */ PersonalMsglistModel a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj(PersonalMsglistModel personalMsglistModel, int i) {
        super(0);
        this.a = personalMsglistModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 != null) {
            if (customResponsedMessage2.g() == 2013001) {
                this.a.c(customResponsedMessage2);
            } else if (customResponsedMessage2.g() == 2001147) {
                this.a.b(customResponsedMessage2);
            } else if (customResponsedMessage2.g() == 2001150) {
                this.a.a(customResponsedMessage2);
            }
        }
    }
}
