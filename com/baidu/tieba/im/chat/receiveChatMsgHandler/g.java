package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupMsgData;
/* loaded from: classes.dex */
public final class g extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 instanceof GroupMsgData) {
            b.a((GroupMsgData) customResponsedMessage2, false);
            com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2012111));
        }
    }

    public g() {
        super(2013004);
    }
}
