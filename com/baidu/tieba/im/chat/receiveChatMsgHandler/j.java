package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.data.GroupMsgData;
/* loaded from: classes.dex */
public final class j extends com.baidu.adp.framework.c.a {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(CustomResponsedMessage<?> customResponsedMessage) {
        CustomResponsedMessage<?> customResponsedMessage2 = customResponsedMessage;
        if (customResponsedMessage2 instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage2;
            com.baidu.adp.lib.util.f.e("GET Personal Gid PULLMSG=" + groupMsgData.b().getGroupId());
            com.baidu.tieba.im.pushNotify.a.d().b(h.a(groupMsgData), new k(this));
            com.baidu.tieba.im.chat.x.b().a(groupMsgData);
        }
    }

    public j() {
        super(2013003);
    }
}
