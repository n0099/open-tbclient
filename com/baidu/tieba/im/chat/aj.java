package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aj extends com.baidu.adp.framework.c.a {
    final /* synthetic */ x a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(x xVar, int i) {
        super(0);
        this.a = xVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 == null) {
            com.baidu.adp.lib.util.f.b("msg == null");
        } else if (customResponsedMessage2.g() == 2001103) {
            if (customResponsedMessage2 instanceof LoadDraftResponsedMessage) {
                this.a.a(customResponsedMessage2);
            }
        } else if (customResponsedMessage2.g() != 2001105) {
            com.baidu.adp.lib.util.f.b("convert error need GroupMsgData");
        } else if (customResponsedMessage2 instanceof LoadHistoryResponsedMessage) {
            this.a.a(customResponsedMessage2);
        }
    }
}
