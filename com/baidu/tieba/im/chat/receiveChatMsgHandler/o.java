package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupMsgData;
/* loaded from: classes.dex */
public final class o extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage2;
            com.baidu.tieba.im.pushNotify.a.d().a(m.a(groupMsgData), m.a, new p(this));
            com.baidu.tieba.im.chat.x.b().a(groupMsgData);
        }
    }

    public o() {
        super(2013001);
    }
}
